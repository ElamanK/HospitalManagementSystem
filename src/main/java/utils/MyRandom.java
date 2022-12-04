package utils;
import java.util.Random;

public class MyRandom {
    public static String getRandomNumberAsString(){
        Random random = new Random();
        return String.valueOf(random.nextInt(10000));
    }

}
