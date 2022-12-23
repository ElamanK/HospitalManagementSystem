package lambda.generic_lambda;
@FunctionalInterface
public interface IFindItem <T>{
    int SearchItem(T item, T[] items);
}
