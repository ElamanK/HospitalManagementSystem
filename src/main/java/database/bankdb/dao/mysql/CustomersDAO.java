package database.bankdb.dao.mysql;
import database.bankdb.connectionpool.ConnectionPool;
import database.bankdb.dao.daointerfaces.ICustomersDAO;
import database.bankdb.models.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);

    private final static String GET_CUSTOMER = "SELECT * FROM customers where customer_id=?";
    private final static String GET_PHONE_BY_ID = "SELECT phone FROM customers where id=?";
    private final static String GET_ALL_CUSTOMERS = "SELECT * FROM customers";
    private final static String UPDATE_CUSTOMER_BY_ID = "UPDATE customers SET account_id = ?, " +
            "firstname = ?, lastname = ?, address = ?, email_address = ?, phone = ?, ssn = ? WHERE customer_id = ?";
    private final static String CREATE_CUSTOMER = "INSERT INTO customers (account_id, firstname, lastname, address, " +
            "email_address, phone, ssn) VALUES (?,?,?,?,?,?,?)";
    private final static String REMOVE_CUSTOMER = "DELETE FROM customers where customer_id = ?";


    @Override
    public void insertEntity(Customer entity) {

    }

    @Override
    public Customer getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Customer customer = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_CUSTOMER)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    customer = new Customer();
                    customer.setCustomer_id(rs.getInt("customer_id"));
                    customer.setAccountId(rs.getInt("account_id"));
                    customer.setFirstname(rs.getString("firstname"));
                    customer.setLastname(rs.getString("lastname"));
                    customer.setAddress(rs.getString("address"));
                    customer.setEmailAddress(rs.getString("email_address"));
                    customer.setPhone(rs.getString("phone"));
                    customer.setSsn(rs.getString("ssn"));
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
        return customer;
    }

    @Override
    public void updateEntity(int id, Customer entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID)) {
            statement.setInt(1, entity.getAccountId());
            statement.setString(2, entity.getFirstname());
            statement.setString(3, entity.getLastname());
            statement.setString(4, entity.getAddress());
            statement.setString(5, entity.getEmailAddress());
            statement.setString(6, entity.getPhone());
            statement.setString(7, entity.getSsn());
            statement.setInt(8, id);
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
    public Customer createEntity(Customer entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_CUSTOMER)) {
            statement.setInt(1, entity.getAccountId());
            statement.setString(2, entity.getFirstname());
            statement.setString(3, entity.getLastname());
            statement.setString(4, entity.getAddress());
            statement.setString(5, entity.getEmailAddress());
            statement.setString(6, entity.getPhone());
            statement.setString(7, entity.getSsn());
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
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_CUSTOMER)) {
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
    public List<Customer> getAllEntities() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Customer> listOfCustomers = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_CUSTOMERS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setAccountId(rs.getInt("account_id"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setAddress(rs.getString("address"));
                customer.setEmailAddress(rs.getString("email_address"));
                customer.setPhone(rs.getString("phone"));
                customer.setSsn(rs.getString("ssn"));
                listOfCustomers.add(customer);
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
        return listOfCustomers;
    }


    @Override
    public String getPhoneById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        String phone = "";
        try (PreparedStatement ps = connection.prepareStatement(GET_PHONE_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    phone = rs.getString("phone");
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
        return phone;
    }
}
