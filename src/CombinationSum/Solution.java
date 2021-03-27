package CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        getCombinations(candidates, result, combination, target, 0);
        return result;
    }

    private void getCombinations(int[] candidates, List<List<Integer>> result, List<Integer> combination, int target, int pos) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = pos; i < candidates.length; i++) {
                combination.add(candidates[i]);
                getCombinations(candidates, result, combination, target - candidates[i], i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
