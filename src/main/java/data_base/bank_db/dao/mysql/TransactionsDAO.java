package data_base.bank_db.dao.mysql;
import data_base.bank_db.connection_pool.ConnectionPool;
import data_base.bank_db.dao.dao_interfaces.ITransactionsDAO;
import data_base.bank_db.models.Transactions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDAO implements ITransactionsDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(TransactionsDAO.class);

    private final static String GET_TRANSACTION = "SELECT * FROM transactions where transaction_id=?";
    private final static String GET_TRANSACTION_AMOUNT_BY_ID = "SELECT transaction_amount FROM transactions where transaction_id=?";
    private final static String GET_ALL_TRANSACTIONS = "SELECT * FROM transactions";
    private final static String UPDATE_TRANSACTION_BY_ID = "UPDATE transactions SET transaction_date = ?, " +
            "transaction_amount = ?, new_balance = ?, account_id = ?, employee_id = ?, transaction_type_id = ? WHERE transaction_id = ?";
    private final static String CREATE_TRANSACTION = "INSERT INTO transactions (transaction_date, transaction_amount, new_balance, account_id, " +
            "employee_id, transaction_type_id) VALUES (?,?,?,?,?,?)";
    private final static String REMOVE_TRANSACTION = "DELETE FROM transactions where transaction_id = ?";

    @Override
    public Transactions getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Transactions transaction = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_TRANSACTION)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    transaction = new Transactions();
                    transaction.setTransactionId(rs.getInt("transaction_id"));
                    transaction.setTransactionDate(rs.getDate("transaction_date"));
                    transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                    transaction.setNewBalance(rs.getDouble("new_balance"));
                    transaction.setAccountId(rs.getInt("account_id"));
                    transaction.setEmployeeId(rs.getInt("employee_id"));
                    transaction.setTransactionTypeId(rs.getInt("transaction_type_id"));
                }
            } catch (SQLException e) {
                LOGGER.error(e);
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
        return transaction;
    }

    @Override
    public void updateEntity(int id, Transactions entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_TRANSACTION_BY_ID)) {
            statement.setDate(1, entity.getTransactionDate());
            statement.setDouble(2, entity.getTransactionAmount());
            statement.setDouble(3, entity.getNewBalance());
            statement.setInt(4, entity.getAccountId());
            statement.setInt(5, entity.getEmployeeId());
            statement.setInt(6, entity.getTransactionTypeId());
            statement.setInt(7, id);
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
    public Transactions createEntity(Transactions entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_TRANSACTION)) {
            statement.setDate(1, entity.getTransactionDate());
            statement.setDouble(2, entity.getTransactionAmount());
            statement.setDouble(3, entity.getNewBalance());
            statement.setInt(4, entity.getAccountId());
            statement.setInt(5, entity.getEmployeeId());
            statement.setInt(6, entity.getTransactionTypeId());
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
        return entity;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_TRANSACTION)) {
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
    public List<Transactions> getAllEntities() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Transactions> listOfTransactions = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_TRANSACTIONS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transactions transaction = new Transactions();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setTransactionDate(rs.getDate("transaction_date"));
                transaction.setTransactionAmount(rs.getDouble("transaction_amount"));
                transaction.setNewBalance(rs.getDouble("new_balance"));
                transaction.setAccountId(rs.getInt("account_id"));
                transaction.setEmployeeId(rs.getInt("employee_id"));
                transaction.setTransactionTypeId(rs.getInt("transaction_type_id"));
                listOfTransactions.add(transaction);
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
        return listOfTransactions;
    }

    @Override
    public double getTransactionAmountById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        double transactionAmount = 0;
        try (PreparedStatement ps = connection.prepareStatement(GET_TRANSACTION_AMOUNT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    transactionAmount = rs.getDouble("transaction_amount");
                }
            } catch (SQLException e) {
                LOGGER.error(e);
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
        return transactionAmount;
    }
}
