package fcknojob.java.leetcode._907_sum_of_subarray_minimums;


class Solution {
    public int sumSubarrayMins(int[] A) {
        int M = 1_000_000_000 + 7;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int l = i-1;
            int r = i+1;
            // duplicate elements, left >=, right >
            while (l>=0 && A[l] >= A[i]) {l--;}
            while (r<A.length && A[r] > A[i]) {r++;}
            result += A[i] * (i-l) * (r-i);
            result %= M;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,1,1,1};
        int r = new Solution().sumSubarrayMins(A);
        System.out.println(r);
    }
}