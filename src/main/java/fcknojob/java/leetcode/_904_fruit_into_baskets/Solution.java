package fcknojob.java.leetcode._904_fruit_into_baskets;


import java.util.Arrays;

class Solution {
    public int totalFruit(int[] tree) {
        int treeLength = tree.length;

        if (treeLength == 0) return 0;

        // calculate from the tail of tree array, keep the longest same type sequence(1-type) length from the current ind backwards.
        int[] dp1 = new int[treeLength];
        // calculate from the tail of tree array, keep the longest sequence(2-type) length with at most 2 different types from the current ind backwards.
        int[] dp2 = new int[treeLength];
        // keep the another type which is different from the current type in the dp2 sequence; it is -1 at tail.
        int[] dp2Type = new int[treeLength];

        int result = 1;

        dp1[treeLength-1] = 1;
        for (int i = treeLength-2; i >= 0; i--) {
            if (tree[i] == tree[i+1]) {
                dp1[i] = dp1[i+1] + 1;
            } else {
                dp1[i] = 1;
            }
        }

        dp2[treeLength-1] = 1;
        dp2Type[treeLength-1] = -1;
        for (int i = treeLength-2; i>=0; i--) {
            if (tree[i] == tree[i+1]) { // type same as the right tree's type
                dp2[i] = dp2[i+1] + 1;
                dp2Type[i] = dp2Type[i+1];
            } else if (tree[i] == dp2Type[i+1] || dp2Type[i+1] == -1) { // type same as the another type in the right tree's longest 2-type sequence
                dp2[i] = dp2[i+1] + 1;
                dp2Type[i] = tree[i+1];
            } else { // other case, sequence length count based on the dp1(1-type sequence)
                dp2[i] = dp1[i+1] + 1;
                dp2Type[i] = tree[i+1];
            }

            if (dp2[i] > result) result = dp2[i];
        }

//        System.out.println(Arrays.toString(dp1));
//        System.out.println(Arrays.toString(dp2));
//        System.out.println(Arrays.toString(dp2Type));

        return result;
    }

    public static void main(String[] args) {
        int[] tree = {0,1,6,6,4,4,6};
        int r = new Solution().totalFruit(tree);

        System.out.print(r);
    }
}