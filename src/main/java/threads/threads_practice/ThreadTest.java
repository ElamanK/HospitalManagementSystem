package threads.threads_practice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadTest {

    private static final Logger LOGGER = LogManager.getLogger(ThreadTest.class);

    public static void main(String[] args) {
        Thread thread1 = new ThreadExtends();
        ThreadImplements thread2 = new ThreadImplements();

        thread1.start();
        new Thread(thread2).start();
    }
}
