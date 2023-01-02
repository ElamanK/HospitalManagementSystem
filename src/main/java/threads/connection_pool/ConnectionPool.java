package threads.connection_pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Vector;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static Connection connection;
    private static Vector<Connection> connectionPool;
    private static final int INITIAL_POOL_SIZE = 5;


    public  ConnectionPool(){
        connectionPool = new Vector<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(connection);
        }
    }

    public static void getConnection() {
        if(connectionPool.isEmpty()){
            LOGGER.info("No available connection, please wait");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.info("Exception occurred "+e);
            }
                releaseConnection();
        }else {
            LOGGER.info("Connection is ready");
            connectionPool
                    .remove(connectionPool.size()-1);
        }

    }

    public static void releaseConnection() {
        connectionPool.add(new Connection());
    }

    public static int getSize() {
        return connectionPool.size();
    }

    }





