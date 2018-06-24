package fcknojob.java.leetcode._347_top_k_frequent_elements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> counter = new HashMap<>();

        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> buckets = new HashMap<Integer, List<Integer>>();

        for (int n: counter.keySet()) {
            int v = counter.get(n);
            buckets.getOrDefault(v, new ArrayList<Integer>()).add(n);
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
        List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        System.out.println(nums);
    }
}