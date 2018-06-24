package fcknojob.java.leetcode._347_top_k_frequent_elements;

import java.util.*;

/*
 * bucket sort
 * try Map<,List<>>
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counter = new HashMap<>();

        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<Integer, List<Integer>>();

        for (int n: counter.keySet()) {
            int v = counter.get(n);
            buckets.putIfAbsent(v, new ArrayList<>());
            buckets.get(v).add(n);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = nums.length; i > 0 && topK.size() < k; i--) {
            if (buckets.get(i) != null) {
                for (int n: buckets.get(i)) {
                    topK.add(n);
                }
            }
        }

        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(nums, 2));
    }
}