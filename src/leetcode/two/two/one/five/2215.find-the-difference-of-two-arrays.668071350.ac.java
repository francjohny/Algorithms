package leetcode.two.two.one.five;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        char[] buckets = new char[2002];
        for(int num: nums1) {
            num = ((num < 0) ? num + 2001 : num);
            buckets[num] = 'X';
        }
        for(int num: nums2) {
            num = ((num < 0) ? num + 2001 : num);
            buckets[num] = (buckets[num] == 'X' || buckets[num] == 'Z') ? 'Z' : 'Y';
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            char ch = buckets[i];
            if (ch == 'X') {
                l1.add(i <= 1000 ? i : (i - 2001));
            } else if (ch == 'Y') {
                l2.add(i <= 1000 ? i : (i - 2001));
            }    
        }
        ans.add(l1);
        ans.add(l2);
        return ans;
    }
}
