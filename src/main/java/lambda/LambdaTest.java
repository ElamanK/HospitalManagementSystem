package lambda;
import lambda.genericlambda.IFindItem;
import lambda.genericlambda.ISumArray;
import lambda.genericlambda.IValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;


public class LambdaTest {
    private static final Logger LOGGER = LogManager.getLogger(LambdaTest.class);
    public static void main(String[] args) {
        IValue<Integer> integerIValue = ()-> 15;
        LOGGER.info("Integer value from lambda "+integerIValue.getValue());
        IValue<String> stringIValue = () -> "Hello";
        LOGGER.info("String value from lambda "+stringIValue.getValue());

        IFindItem<String> findItem = (item, items) -> {
            int count=0;
            for (String s : items)
                if (item.equals(s))
                    count++;
            return count;
        };
        String[] stringValues = { "abc", "abd", "def", "acf", "abc", "afx" };
        LOGGER.info("Count of abc -> " + findItem.SearchItem("abc", stringValues));

        IFindItem<Integer> findInteger = (item, items) -> {
            int count1=0;
            for (Integer s : items)
                if (item.equals(s))
                    count1++;
            return count1;
        };
        Integer[] intValues = {5,1,2,3,4,5};
        int targetValue=5;
        LOGGER.info("Count of "+targetValue+" -> "+findInteger.SearchItem(targetValue,intValues));

        Integer[] intArray1={1,2,3,4,5};
        Integer[] intArray2={1,2,3,4,5};
        ISumArray<Integer> integerISumArray  = (X, Y) -> {
            Integer[] Z = new Integer[X.length];
            for (int i=0; i<X.length; i++)
            {
                Z[i] = X[i] + Y[i];
            }
            return Z;
        };
        Integer[] intArray3 = integerISumArray.SumArrays(intArray1,intArray2);
        LOGGER.info("Result "+Arrays.toString(intArray3));


    }
}
