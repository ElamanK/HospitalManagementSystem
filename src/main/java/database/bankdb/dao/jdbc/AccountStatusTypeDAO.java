package database.bankdb.dao.jdbc;

import database.bankdb.connectionpool.ConnectionPool;
import database.bankdb.dao.daointerfaces.IAccountStatusTypeDAO;
import database.bankdb.models.AccountStatusType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountStatusTypeDAO implements IAccountStatusTypeDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(AccountStatusTypeDAO.class);

    private final static String GET_ACCOUNT_STATUS_TYPE = "SELECT * FROM account_status_type where id=?";
    private final static String UPDATE_ACCOUNT_STATUS_TYPE_DESCRIPTION = "UPDATE account_status_type SET account_status_type_description = ?" +
            "WHERE id = ?";
    private final static String CREATE_ACCOUNT_STATUS_TYPE = "INSERT INTO account_status_type (account_status_type_description) VALUES (?)";
    private final static String REMOVE_ACCOUNT_STATUS_TYPE = "DELETE FROM account_status_type where id = ?";
    private final static String GET_ALL_ACCOUNT_STATUS_TYPES = "SELECT * FROM account_status_type";
    private final static String GET_ACCOUNT_STATUS_BY_ID = "SELECT account_status_type_description FROM account_status_type where id=?";


    @Override
    public List<AccountStatusType> getAllEntities() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<AccountStatusType> accountStatusTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ACCOUNT_STATUS_TYPES);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AccountStatusType accountStatusType = new AccountStatusType();
                accountStatusType.setAccountStatusTypeId(rs.getInt("id"));
                accountStatusType.setAccountStatusTypeDescription(rs.getString("account_status_type_description"));
                accountStatusTypes.add(accountStatusType);
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
        return accountStatusTypes;
    }

    @Override
    public String getAccountStatusById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        String status = "";
        try (PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_STATUS_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    status = rs.getString("account_status_type_description");
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
        return status;
    }


    @Override
    public void insertEntity(AccountStatusType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement statement = connection.prepareStatement(CREATE_ACCOUNT_STATUS_TYPE)) {
            statement.setString(1, entity.getAccountStatusTypeDescription());
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
    public AccountStatusType getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AccountStatusType accountStatusType = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_STATUS_TYPE)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    accountStatusType = new AccountStatusType();
                    accountStatusType.setAccountStatusTypeId(rs.getInt("id"));
                    accountStatusType.setAccountStatusTypeDescription(rs.getString("account_status_type_description"));
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
        return accountStatusType;
    }

    @Override
    public void updateEntity(AccountStatusType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_STATUS_TYPE_DESCRIPTION)) {
            statement.setString(1, entity.getAccountStatusTypeDescription());
            statement.setInt(2, entity.getAccountStatusTypeId());
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
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_ACCOUNT_STATUS_TYPE)) {
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
}
