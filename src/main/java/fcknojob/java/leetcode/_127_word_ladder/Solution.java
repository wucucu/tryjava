package fcknojob.java.leetcode._127_word_ladder;

/*
 * BFS
 */

import java.util.*;

class Solution {

    // beginword and endword are not same
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> notVisitedWordSet = new HashSet<>(wordList);
        wordList.add(beginWord);

        if (!notVisitedWordSet.contains(endWord)) return 0;

        Set<String> q = new HashSet<>();
        int depth = 0;
        q.add(beginWord);

        while (!q.isEmpty()) {
           depth++;
           Set<String> qNext = new HashSet<>();
           for (String currWord: q) {
               for (Iterator<String> iter = notVisitedWordSet.iterator(); iter.hasNext(); ) {
                   String nextWord = iter.next();
                   if (isConnected(currWord, nextWord)) {
                       if (nextWord.equals(endWord)) return depth+1;
                       iter.remove();
                       qNext.add(nextWord);
                   }
               }
           }
           q = qNext;
        }

        return 0;

    }

    // assume w1, w2 same length
    private boolean isConnected(String w1, String w2) {
        int l = w1.length();
        boolean isAlreadyOneDiff = false;
        for (int i = 0; i < l; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (isAlreadyOneDiff) return false;
                isAlreadyOneDiff = true;
            }
        }
        return isAlreadyOneDiff;
    }

}
