package LRUCache;

import java.util.*;

public class Naive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LRUCache cache = new LRUCache();
        Map<Integer, Integer> keyCountAccess = new HashMap<>();
        while (true) {
            switch (scanner.next()) {
                case "add":
                    int key = scanner.nextInt();
                    cache.set(key, scanner.nextInt());
                    keyCountAccess.put(key, keyCountAccess.getOrDefault(key, 0) + 1);
                    break;
                case "get":
                    int key1 = scanner.nextInt();
                    System.out.println(cache.get(key1));
                    keyCountAccess.put(key1, keyCountAccess.getOrDefault(key1, 0) + 1);
                    break;
                case "remove":
                    System.out.println(cache.remove(scanner.nextInt()));
                    break;
                case "evict":
                    for (Integer key2 : keyCountAccess.keySet()) {
                        if (Collections.min(keyCountAccess.values()).equals(keyCountAccess.get(key2))) {
                            cache.remove(key2);
                            break;
                        }
                    }
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }
}

class LRUCache {
    private LinkedHashMap<Integer, Integer> map;

    LRUCache() {
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public int remove(int key) {
        if (get(key) > 0) {
            return map.remove(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
