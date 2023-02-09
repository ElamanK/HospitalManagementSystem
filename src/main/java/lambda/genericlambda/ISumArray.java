package lambda.genericlambda;
@FunctionalInterface
public interface ISumArray <T extends Number>{
    T[] SumArrays(T[] X, T[] Y);

}
