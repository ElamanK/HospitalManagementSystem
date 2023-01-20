package data_base.bank_db.dao.mysql;

import data_base.bank_db.connection_pool.ConnectionPool;
import data_base.bank_db.dao.dao_interfaces.IEmployeesDAO;
import data_base.bank_db.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeesDAO {

    ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);

    private static final String GET_EMPLOYEE = "SELECT * FROM employees WHERE employee_id = ?";
    private final static String GET_ALL_EMPLOYEES = "SELECT * FROM employees";
    private final static String CREATE_EMPLOYEE = "INSERT INTO employees (firstname, lastname) " +
            "VALUES (?,?)";
    private final static String REMOVE_EMPLOYEE = "DELETE FROM employees WHERE employee_id = ?";
    private final static String UPDATE_EMPLOYEE = "UPDATE employees SET firstname=?, lastname = ? WHERE employee_id = ?";


    @Override
    public Employees getEntityById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        Employees employee = null;
        try (PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEE)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = new Employees();
                    employee.setId(rs.getInt("employee_id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
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
        return employee;
    }

    @Override
    public void updateEntity(int id, Employees entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            statement.setString(1, entity.getFirstname());
            statement.setString(2, entity.getLastname());
            statement.setInt(3, id);
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
    public Employees createEntity(Employees entity) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_EMPLOYEE)) {
            statement.setString(1, entity.getFirstname());
            statement.setString(2, entity.getLastname());
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
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_EMPLOYEE)) {
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
    public List<Employees> getAllEntities() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Employees> listOfEmployees = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_EMPLOYEES);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setId(rs.getInt("employee_id"));
                employee.setFirstname(rs.getString("firstname"));
                employee.setLastname(rs.getString("lastname"));
                listOfEmployees.add(employee);
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
        return listOfEmployees;
    }
}
