package database.patterns.daofactory;

import com.hospital_management.exceptions.UnsupportedFactoryException;

public class DBFactoryGenerator {

    public static AbstractDAOFactory getFactory(DBConnectionType connectionType){
        switch (connectionType){
            case JDBC:
                return new JDBCDAOFactory();
            case MYBATIS:
                return new MyBatisDAOFactory();
            default:
                try {
                    throw new UnsupportedFactoryException("Connection type does not exist");
                } catch (UnsupportedFactoryException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}
