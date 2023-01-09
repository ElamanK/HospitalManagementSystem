package threads.connection_pool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;

public class Connection implements Closeable {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);

    public  void close() {
        LOGGER.info("Connection closed");
    }
}
