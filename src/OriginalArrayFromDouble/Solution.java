package OriginalArrayFromDouble;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length, i = 0;
        int[] res = new int[n/2];
        if (n % 2 == 1) return new int[0];
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num: changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int pairs = 0, unpaired = 0;
        for(int num: Collections.unmodifiableSet(map.keySet())) {
            if(map.get(num) > 0 && map.containsKey(num+num) && map.get(num+num) > 0) {
                map.put(num + num, map.get(num+num) - 1);
                pairs++;
                res[i++] = num;
            }
        }
        if (pairs == n/2) {
            return res;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
    }
}