package lambda.genericlambda;
@FunctionalInterface
public interface IFindItem <T>{
    int SearchItem(T item, T[] items);
}
