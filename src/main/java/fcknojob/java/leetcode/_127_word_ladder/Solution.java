package fcknojob.java.leetcode._127_word_ladder;

/*
 * BFS
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    // beginword and endword are not same, all the word are in the same length
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
                notVisitedWordSet.remove(currWord);

                // switch between two ways of selecting next word
                // large notVisitedWordSet, consider each 1-differ-char word of currWord, check whether it's in notVisitedWordSet
                // small notVisitedWordSet, consider each word in notVisitedWordSet, check wheter it's a 1-differ-char word of currWord
                if (26 <= notVisitedWordSet.size()) {
                    char[] cs = currWord.toCharArray();
                    for (int i = 0; i < cs.length; i++) {
                        char cTemp = cs[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            cs[i] = c;
                            String nextWord = new String(cs);
                            if (qBackup.contains(nextWord)) return depth + 1;
                            if (notVisitedWordSet.contains(nextWord)) qNext.add(nextWord);
                        }
                        cs[i] = cTemp;
                    }
                } else {
                    for (String nextWord : notVisitedWordSet) {
                        if (isConnected(currWord, nextWord)) {
                            if (qBackup.contains(nextWord)) return depth + 1;
                            qNext.add(nextWord);
                        }
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
