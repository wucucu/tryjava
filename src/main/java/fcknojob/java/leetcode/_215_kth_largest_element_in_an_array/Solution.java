package fcknojob.java.leetcode._215_kth_largest_element_in_an_array;


import java.util.PriorityQueue;

/*
 * heap sort
 * try PriorityQueue
 *
 * quick selection with lomuto partition method, c.f., Hoare partition scheme
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        // return findKthLargest_heap(nums, k);
        return findKthLargest_quickselection(nums, k);
    }

    public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);
        for (int n: nums) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek().intValue();
    }

    public int findKthLargest_quickselection(int[] nums, int k) {
        int targetIndex = k - 1;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int pivotIndex = partition(nums, lo, hi);
            if (pivotIndex == targetIndex) {
                break;
            } else if (pivotIndex < targetIndex) {
                lo = pivotIndex + 1;
            } else {
                hi = pivotIndex - 1;
            }
        }
        return nums[targetIndex];
    }

    /**
     * qsort partition on int array nums inplace, index from lo to hi, use nums[hi] as pivot,
     * larger elements on lo side, smaller elements on hi side
     * https://en.wikipedia.org/wiki/Quicksort#Lomuto_partition_scheme
     * @param nums
     * @param lo first index of partition interval
     * @param hi last index of partition interval
     * @return pivot index in nums
     */
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int pivotFinalIndex = lo;
        for (int i=lo; i<=hi-1; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, pivotFinalIndex++);
            }
        }
        swap(nums, pivotFinalIndex, hi);
        return pivotFinalIndex;
    }

    private void swap(int[] nums, int i, int j) {
        if (i==j) return;
        int ti = nums[i], tj = nums[j];
        nums[i] = tj;
        nums[j] = ti;
    }
}