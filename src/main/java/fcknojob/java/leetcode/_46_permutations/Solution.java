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
        return permutate_backtracking(nums);
    }

    private List<List<Integer>> permutate_backtracking(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        return rst;
    }

}