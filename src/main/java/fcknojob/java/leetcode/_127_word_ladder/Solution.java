package fcknojob.java.leetcode._127_word_ladder;

/*
 * BFS
 */

import java.util.*;

class Solution {

    // beginword and endword are not same
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordList.add(beginWord);
        Set<String> notVisitedWordSet = new HashSet<>(wordList);

        if (!notVisitedWordSet.contains(endWord)) return 0;

        Set<String> q = new HashSet<>();
        Set<String> qBackup = new HashSet<>();
        int depth = 0;
        q.add(beginWord);
        qBackup.add(endWord);

        while (!q.isEmpty() && !qBackup.isEmpty()) {

            depth++;

            if (q.size() > qBackup.size()) {
                Set<String> qTemp = q;
                q = qBackup;
                qBackup = qTemp;
            }

            Set<String> qNext = new HashSet<>();
            for (String currWord : q) {
                notVisitedWordSet.remove(q);
                for(String nextWord: notVisitedWordSet) {
                    if (isConnected(currWord, nextWord)) {
                        if (qBackup.contains(nextWord)) return depth + 1;
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
