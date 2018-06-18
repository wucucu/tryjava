package fcknojob.java.leetcode._763_partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * try map
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int  SLENGTH = S.length();
        if (SLENGTH == 0) return new ArrayList<>();


        Map<Character, Integer> charLastIndex = new HashMap<Character, Integer>();
        for (int i = 0; i < SLENGTH; i++) {
            char c = S.charAt(i);
            charLastIndex.put(c, i);
        }

        List<Integer> partitionLengths =  new ArrayList<Integer>();
        int currentPartitionHeadIndex = 0;
        int currentPartitionTailIndex = 0;
        for (int i = 0; i <  SLENGTH; i++) {
            char c = S.charAt(i);
            int cLastIndex = charLastIndex.get(c);
            currentPartitionTailIndex = Math.max(cLastIndex, currentPartitionTailIndex);
            if (i == currentPartitionTailIndex) {
                partitionLengths.add(currentPartitionTailIndex - currentPartitionHeadIndex + 1);
                currentPartitionHeadIndex = currentPartitionTailIndex + 1;
            }
        }

        return partitionLengths;

    }
}
