package fcknojob.java.leetcode._345_reverse_vowels_of_a_string;

import java.util.Arrays;
import java.util.HashSet;

/*
  Two Points
  try String toCharArray method
  try HashSet
 */
class Solution {
    public String reverseVowels(String s) {
        final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        int sl = s.length();
        char[] cs = s.toCharArray();

        int i = 0, j = sl-1;
        while (i<j) {
            if (!vowels.contains(cs[i])) {
                i++;
                continue;
            }
            if (!vowels.contains(cs[j])) {
                j--;
                continue;
            }
            char ci = cs[i], cj = cs[j];
            cs[i++] = cj;
            cs[j--] = ci;
        }

        return new String(cs);
    }

}
