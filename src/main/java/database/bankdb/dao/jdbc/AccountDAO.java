package database.bankdb.dao.jdbc;
import database.bankdb.connectionpool.ConnectionPool;
import database.bankdb.dao.daointerfaces.IAccountDAO;
import database.bankdb.models.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(AccountDAO.class);

    private final static String GET_ACCOUNT = "SELECT * FROM accounts where account_id=?";
    private final static String GET_CURRENT_BALANCE_BY_ID = "SELECT current_balance FROM accounts where account_id=?";
    private final static String GET_ALL_ACCOUNT_FROM_ACCOUNTS = "SELECT * FROM accounts";
    private final static String UPDATE_ACCOUNT = "UPDATE accounts SET current_balance = ?, " +
            "account_type_id = ?, account_status_type_id = ? WHERE account_id = ?";
    private final static String CREATE_ACCOUNT = "INSERT INTO accounts (current_balance, account_type_id, account_status_type_id) VALUES (?,?,?)";
    private final static String REMOVE_ACCOUNT = "DELETE FROM accounts where account_id = ?";

    @Override
    public List<Account> getAllEntities() {
        List<Account> listOfAccounts = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ACCOUNT_FROM_ACCOUNTS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getInt("account_id"));
                account.setCurrentBalance(rs.getDouble("current_balance"));
                account.setAccountTypeId(rs.getInt("account_type_id"));
                account.setAccountStatusTypeId(rs.getInt("account_status_type_id"));
                listOfAccounts.add(account);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }  finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return listOfAccounts;
    }

    @Override
    public double getCurrentBalanceById(int id) {
        Connection connection = connectionPool.getConnection();
        double currentBalance = 0;
        try (PreparedStatement ps = connection.prepareStatement(GET_CURRENT_BALANCE_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    currentBalance = rs.getDouble("current_balance");
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }  finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return currentBalance;
    }


    @Override
    public void insertEntity(Account entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_ACCOUNT)) {
            statement.setDouble(1, entity.getCurrentBalance());
            statement.setInt(2, entity.getAccountTypeId());
            statement.setInt(3, entity.getAccountStatusTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }  finally {
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
    public Account getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Account account = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    account = new Account();
                    account.setAccountId(rs.getInt("account_id"));
                    account.setCurrentBalance(rs.getDouble("current_balance"));
                    account.setAccountTypeId(rs.getInt("account_type_id"));
                    account.setAccountStatusTypeId(rs.getInt("account_status_type_id"));
                }
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return account;
    }

    @Override
    public void updateEntity(int id, Account entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ACCOUNT)) {
            statement.setDouble(1, entity.getCurrentBalance());
            statement.setInt(2, entity.getAccountTypeId());
            statement.setInt(3, entity.getAccountStatusTypeId());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }  finally {
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
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_ACCOUNT)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
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
