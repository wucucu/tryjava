package fcknojob.java.leetcode._93_restore_ip_address;

/*
 * backtracking
 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> results;

    public List<String> restoreIpAddresses(String s){
        results = new ArrayList<>();

        helper(0, "", s);

        return results;
    }

    // k is the current part amount of ip address has been found, or the depth of dfs
    // tempS is the current ip address String
    private void helper(int k, String tempS, String remaingS) {
        if (k == 4) { // k = 0, 1, 2, 3; k = 4 means 4 parts already, while ipv4 has 4 parts.
            if (remaingS.isEmpty()) {
                results.add(tempS.toString());
            }
            return;
        }

        for (int nextPartLength: getPossibleNextIpAddressPartLengths(remaingS)) {
            String part = remaingS.substring(0, nextPartLength);
            if (k != 0) { // not first part
                part = "." + part;
            }
            helper(k + 1, tempS + part, remaingS.substring(nextPartLength));
        }

    }

    // 0, 1~255
    private List<Integer> getPossibleNextIpAddressPartLengths(String remaingS) {
        int l = remaingS.length();
        List<Integer> possibleLengths = new ArrayList<>();

        if (l == 0) return possibleLengths;
        if (remaingS.charAt(0) == '0') { // 0
            possibleLengths.add(1);
            return possibleLengths;
        }

        for (int i = 1; i<=3 & i <= l; i++) { // 1 ~ 255
            String t = remaingS.substring(0, i);
            if (Integer.valueOf(t) <= 255) {
                possibleLengths.add(i);
            }
        }

        return  possibleLengths;
    }


}