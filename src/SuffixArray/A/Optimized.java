package SuffixArray.A;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Optimized {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next();
        str += '$';
        int n = str.length();
        int[] p = new int[n], c = new int[n];
        buildEquivalenceClass(str, n, p, c);
        int k = 0;
        while ((1 << k) < n) {
            List<Pair<Pair<Integer, Integer>, Integer>> eqClassIndexList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                eqClassIndexList.add(new Pair<>(new Pair<>(c[i], c[(i + (1 << k)) % n]), i));
            }
            List<Pair<Pair<Integer, Integer>, Integer>> sortedEqClassIndexList = eqClassIndexList
                    .stream()
                    .sorted(getEqClassComparator())
                    .collect(Collectors.toList());
            for (int i = 0; i < n; i++) {
                p[i] = sortedEqClassIndexList.get(i).value;
            }
            c[p[0]] = 0;
            for (int i = 1; i < n; i++) {
                if (sortedEqClassIndexList.get(i).key.key.equals(sortedEqClassIndexList.get(i - 1).key.key) &&
                        sortedEqClassIndexList.get(i).key.value.equals(sortedEqClassIndexList.get(i - 1).key.value)) {
                    c[p[i]] = c[p[i - 1]];
                } else {
                    c[p[i]] = c[p[i - 1]] + 1;
                }
            }
            k++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(p[i] + " " + str.substring(p[i]));
        }
    }

    private static Comparator<Pair<Pair<Integer, Integer>, Integer>> getEqClassComparator() {
        return (t1, t2) -> {
            if ((t1.key.key > t2.key.key) || (t1.key.key.equals(t2.key.key) && t1.key.value > t2.key.value)) {
                return 1;
            }
            if (t1.key.key.equals(t2.key.key) && t1.key.value.equals(t2.key.value)) {
                return 0;
            }
            return -1;

        };
    }

    private static void buildEquivalenceClass(String str, int n, int[] p, int[] c) {
        List<Pair<Character, Integer>> characterIndexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            characterIndexList.add(new Pair<>(str.charAt(i), i));
        }
        List<Pair<Character, Integer>> sortedCharacterIndexList = characterIndexList
                .stream()
                .sorted(Comparator.comparingInt(characterIntegerPair2 -> characterIntegerPair2.key))
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            p[i] = sortedCharacterIndexList.get(i).value;
        }
        c[p[0]] = 0;
        for (int i = 1; i < n; i++) {
            if (sortedCharacterIndexList.get(i).key == sortedCharacterIndexList.get(i - 1).key) {
                c[p[i]] = c[p[i - 1]];
            } else {
                c[p[i]] = c[p[i - 1]] + 1;
            }
        }
    }
}

class Pair<K, V> implements Serializable {
    public K key;

    public K getKey() {
        return key;
    }

    public V value;

    public V getValue() {
        return value;
    }

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (!Objects.equals(key, pair.key)) return false;
            return Objects.equals(value, pair.value);
        }
        return false;
    }
}
