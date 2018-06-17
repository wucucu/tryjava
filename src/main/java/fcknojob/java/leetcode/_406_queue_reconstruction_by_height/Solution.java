package fcknojob.java.leetcode._406_queue_reconstruction_by_height;

import java.util.Arrays;
import java.util.ArrayList;
/*
 * try ArrayList
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) -> (a[0]!=b[0] ? b[0]-a[0] : a[1]-b[1]));

        ArrayList<int[]> resultArrayList = new ArrayList<>();
        for (int[] p: people) {
            resultArrayList.add(p[1], p);
        }


        return resultArrayList.toArray(new int[people.length][]);
    }
}