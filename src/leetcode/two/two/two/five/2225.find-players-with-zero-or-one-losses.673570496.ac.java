package leetcode.two.two.two.five;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winners = new HashSet<>();
        Set<Integer> losers = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] match: matches) {
            winners.add(match[0]);
            losers.add(match[1]);
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        winners.removeAll(losers);
        List<Integer> arr1 = new ArrayList<Integer>(winners);
        Collections.sort(arr1);
        result.add(arr1);
        List<Integer> arr2 = map.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        Collections.sort(arr2);
        result.add(arr2);
        return result;
    }
}
