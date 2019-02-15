package consoleappmaven.structures.map;

/**
 * @author atsikhamirau on 11.02.2019
 */
public interface Map<K, V> {

    V get(Object key);

    void put(K key, V value);

}
