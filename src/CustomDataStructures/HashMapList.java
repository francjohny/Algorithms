package CustomDataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * The HashMapList is essentially a shorthand for HashMap<T, ArrayList<E>>.
 * It allows us to map from an item of type T to an ArrayList of type E.
 *
 * Ordinarily, we would have to write something like this:
 * HashMap<Integer, ArrayList<String>> mapList = new HashMap<>();
 * for(String s : strings) {
 *   int key = getBucket(s);
 *   if(!mapList.containsKey(key))
 *     mapList.put(key, new ArrayList<>());
 *   mapList.get(key).add(s);
 * }
 *
 * Goal: to write something like this:
 * HashMapList<Integer, String> mapList = new HashMapList<>();
 * for(String s : strings) {
 *   int key = getBucket(s);
 *   mapList.put(key, s);
 * }
 */
public class HashMapList<T, E> {
    private HashMap<T, ArrayList<E>> mapList;

    public HashMapList() {
        this.mapList = new HashMap<>();
    }

    public HashMapList(int n) {
        this.mapList = new HashMap<>(n);
    }

    /* Insert item into list at key. */
    public void put(T key, E item) {
        if (!mapList.containsKey(key))
            mapList.put(key, new ArrayList<>());
        mapList.get(key).add(item);
    }

    /* Insert list of items at key */
    public void put(T key, ArrayList<E> items) {
        mapList.put(key, items);
    }

    /* Remove item from list at key */
    public int remove(T key, E item) {
        if (containsKey(key) && mapList.get(key).size() != 0) {
            mapList.get(key).remove(item);
            return 1;
        }
        return 0;
    }

    /* Get list of items at key. */
    public ArrayList<E> get(T key) {
        return mapList.get(key);
    }

    /* Check if hashmaplist contains key. */
    public boolean containsKey(T key) {
        return mapList.containsKey(key);
    }

    /* Check if the list at key contains value. */
    public boolean containsValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null)
            return false;
        return list.contains(value);
    }

    /* Get the list of keys. */
    public Set<T> get() {
        return mapList.keySet();
    }
}
