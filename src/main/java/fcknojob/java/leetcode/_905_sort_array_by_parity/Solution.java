package fcknojob.java.leetcode._905_sort_array_by_parity;


import java.util.Arrays;

class Solution {
    public int[] sortArrayByParity(int[] A) {

        int resultLength = A.length;
        int[] result = new int[resultLength];

        int i = 0; // front ind
        int j = resultLength-1; //back ind

        for (int ind=0; ind < resultLength; ind++) {
            // put even in the front, odd in the back
            if (A[ind] % 2 == 0) {
                result[i++] = A[ind];
            } else {
                result[j--] = A[ind];
            }
        }

        return result;
    }

    public static void main(String[] Args) {
        int[] A = {1,2,3,4,5};
        int[] B = new Solution().sortArrayByParity(A);

        System.out.print(Arrays.toString(B));
    }
}