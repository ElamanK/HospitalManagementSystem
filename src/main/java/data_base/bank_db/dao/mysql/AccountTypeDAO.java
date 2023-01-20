package data_base.bank_db.dao.mysql;

import data_base.bank_db.connection_pool.ConnectionPool;
import data_base.bank_db.dao.dao_interfaces.IAccountTypeDAO;
import data_base.bank_db.models.AccountType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeDAO implements IAccountTypeDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(AccountTypeDAO.class);

    private final static String GET_ACCOUNT_TYPE = "SELECT * FROM account_type where id=?";
    private final static String UPDATE_ACCOUNT_TYPE_DESCRIPTION = "UPDATE account_type SET account_type_description = ?" +
            "WHERE id = ?";
    private final static String CREATE_ACCOUNT_TYPE = "INSERT INTO account_type (account_type_description) VALUES (?)";
    private final static String REMOVE_ACCOUNT_TYPE = "DELETE FROM account_type where id = ?";
    private final static String GET_ALL_ACCOUNT_TYPE = "SELECT * FROM account_type";

    @Override
    public AccountType getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        AccountType accountType = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT_TYPE)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    accountType = new AccountType();
                    accountType.setAccountTypeId(rs.getInt("id"));
                    accountType.setAccountTypeDescription(rs.getString("account_type_description"));
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
        return accountType;
    }

    @Override
    public void updateEntity(int id, AccountType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT_TYPE_DESCRIPTION)) {
            statement.setString(1, entity.getAccountTypeDescription());
            statement.setInt(2, id);
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
    public AccountType createEntity(AccountType entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_ACCOUNT_TYPE)) {
            statement.setString(1, entity.getAccountTypeDescription());
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
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_ACCOUNT_TYPE)) {
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
    public List<AccountType> getAllEntities() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<AccountType> listOfAccountTypes = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ACCOUNT_TYPE);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AccountType accountType = new AccountType();
                accountType.setAccountTypeId(rs.getInt("id"));
                accountType.setAccountTypeDescription(rs.getString("account_type_description"));
                listOfAccountTypes.add(accountType);
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
        return listOfAccountTypes;
    }
}
