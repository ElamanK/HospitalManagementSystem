package threads.threads_practice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadExtends extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(ThreadExtends.class);

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            LOGGER.info(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.info(e);
            }
        }
    }
}

