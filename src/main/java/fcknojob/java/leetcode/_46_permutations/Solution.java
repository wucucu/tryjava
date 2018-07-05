package fcknojob.java.leetcode._46_permutations;

/*
 * N different elemnts have N! permutations in total.
 * Try trivial backtracking, which needs 2*N! element swap in position.
 * Try Heap's Algorithm, which needs N! element swap in position.
 *
 * Heap's Algorithm wikipedia page
 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
 * Sedgewick, Robert. "a talk on Permutation Generation Algorithms"
 * http://www.cs.princeton.edu/~rs/talks/perms.pdf
 *
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        generateHeap(nums.length, rst, nums);
        return rst;
    }

    private void generateBacktracking(int N, List<List<Integer>> rst, int[] nums) {
        if (N==1) {addPerm(rst, nums); return;}
        for (int c = 0; c < N; c++) { // fix an element in the last position, generate remaining N-1 elements perms
            swap(nums, c, N-1);
            generateBacktracking(N-1, rst, nums);
            swap(nums, c, N-1);
        }
    }

    private void generateHeap(int N, List<List<Integer>> rst, int[] nums) {
        if (N==1) {addPerm(rst, nums); return;}
        for (int c = 0; c < N; c++) {
            generateHeap(N-1, rst, nums);
            int i = N % 2==1 ? 1 : c;
            swap(nums, i, N-1);
        }
    }

    private void swap(int[] p, int i, int j) {
        int t = p[i];
        p[i] = p[j];
        p[j] = t;
    }

    private void addPerm(List<List<Integer>> rst, int[] p) {
        List<Integer> perm = new ArrayList<>();
        for (int x: p) perm.add(x);
        rst.add(perm);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.print(new Solution().permutate(nums));
    }
}