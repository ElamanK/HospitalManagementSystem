package lambda.genericlambda;
@FunctionalInterface
public interface IValue<T> {
    T getValue();
}
