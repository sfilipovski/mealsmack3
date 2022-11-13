package mk.app.mealsmack.PipeAndFilter;

public interface Filter<T> {
    T execute(T input);
}
