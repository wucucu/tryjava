package fcknojob.java.leetcode._75_sort_colors;


/*
 * dutch flag problem
 * 3-way partition inplace
 */
class Solution{

    public void sortColors(int[] nums) {
        partition3(nums, 1);
    }

    /** 3-way partition inplace.
     * https://en.wikipedia.org/wiki/Dutch_national_flag_problem#Pseudocode
     * @param nums before and after each while iter:
     *             nums[j] is the current undecied element
     *             nums[0] ... nums[i-1] store elements less than pivot, i is next index to store next smaller element;
     *             nums[i] ... nums[j-1] store elements equal to pivot, j is next index to store same-value element;
     *             nums[n+1] ... nums[nums.length-1] store elemets greater than pivot, n is next index to store next larger element.
     * @param pivot put elements smaller than pivot at the head of nums, larger onesgit at the tail, same-value in the middle.
     */
    public void partition3(int[] nums, int pivot) {
        int i = 0;
        int j = 0;
        int n = nums.length - 1;

        while (j <= n) {
            if (nums[j] < pivot) {
                swap(nums, i++, j++);
            } else if (nums[j] > pivot) {
                swap(nums, j, n--);
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int ti = nums[i], tj = nums[j];
        nums[i] = tj;
        nums[j] = ti;
    }

}
