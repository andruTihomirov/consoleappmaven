package consoleappmaven.structures.list;

/**
 * @author atsikhamirau on 12.02.2019
 */
public interface List<T> {

    void append(T value);

    void prepend(T value);

    public void delete(T value);

}
