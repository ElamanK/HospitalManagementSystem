package database.bankdb.dao.jdbc;
import database.bankdb.connectionpool.ConnectionPool;
import database.bankdb.dao.daointerfaces.ITransactionTypeDAO;
import database.bankdb.models.TransactionType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionTypeDAO implements ITransactionTypeDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(TransactionTypeDAO.class);

    private static final String GET_TRANSACTION_TYPE = "SELECT * FROM transaction_type WHERE transaction_type_id = ?";
    private static final String UPDATE_TRANSACTION_TYPE = "UPDATE transaction_type SET transaction_type_name =?," +
            "transaction_type_description = ?, transaction_fee =? WHERE transaction_type_id = ?";
    private static final String CREATE_TRANSACTION_TYPE = "INSERT INTO transaction_type (transaction_type_name,transaction_type_description, transaction_fee) " +
            "VALUES(?,?,?)";
    private static final String REMOVE_TRANSACTION_TYPE = "DELETE FROM transaction_type WHERE transaction_type_id = ?";
    private static final String GET_FEE_BY_ID = "SELECT transaction_fee FROM transaction_type WHERE transaction_type_id = ?";


    @Override
    public void insertEntity(TransactionType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_TRANSACTION_TYPE)) {
            statement.setString(1, entity.getTransactionTypeName());
            statement.setString(2, entity.getTransactionTypeDescription());
            statement.setDouble(3, entity.getFee());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public TransactionType getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        TransactionType transactionType = null;
        try(PreparedStatement ps = connection.prepareStatement(GET_TRANSACTION_TYPE)) {
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    transactionType = new TransactionType();
                    transactionType.setTransactionTypeId(rs.getInt("transaction_type_id"));
                    transactionType.setTransactionTypeName(rs.getString("transaction_type_name"));
                    transactionType.setTransactionTypeDescription(rs.getString("transaction_type_description"));
                    transactionType.setFee(rs.getDouble("transaction_fee"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return transactionType;
    }

    @Override
    public void updateEntity(int id, TransactionType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_TRANSACTION_TYPE)) {
            statement.setString(1, entity.getTransactionTypeName());
            statement.setString(2, entity.getTransactionTypeDescription());
            statement.setDouble(3, entity.getFee());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_TRANSACTION_TYPE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public List<TransactionType> getAllEntities() {
        List<TransactionType> transactionTypes = new ArrayList<>();
        return transactionTypes;
    }

    @Override
    public double getTransactionFeeAmountById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        double fee = 0;
        try(PreparedStatement ps = connection.prepareStatement(GET_FEE_BY_ID)) {
            ps.setInt(1,id);
            try {
                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    fee = rs.getDouble("transaction_fee");
                }
            }catch (SQLException e){
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return fee;
    }
}
