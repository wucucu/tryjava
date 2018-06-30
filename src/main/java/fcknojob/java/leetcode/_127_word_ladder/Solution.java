package fcknojob.java.leetcode._127_word_ladder;

/*
 * BFS
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                notVisitedWordSet.remove(currWord);

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


            }
            q = qNext;
        }

        return 0;

    }

}
