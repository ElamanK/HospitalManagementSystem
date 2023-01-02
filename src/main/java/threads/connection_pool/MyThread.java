package threads.connection_pool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {

    private final static Logger LOGGER = LogManager.getLogger(MyThread.class);

    @Override
    public void run() {
        LOGGER.info(currentThread().getName()+" gets connection");
        ConnectionPool.getConnection();
        LOGGER.info(ConnectionPool.getSize()+" available connections");

    }

    public static void main(String[] args) {

        LOGGER.info("Connection pool test starts from this line");
        ConnectionPool cp = new ConnectionPool();

        for (int i = 0; i < 7; i++) {
            MyThread thread = new MyThread();
            thread.start();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                LOGGER.info("Exception "+e);
            }
        }
    }
}
