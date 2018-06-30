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

        Queue<String> q = new LinkedList<>();
        int depth = 0;
        q.add(beginWord);

        while (!q.isEmpty()) {
            int qSize = q.size();
            depth++;
            for (int i = 0; i < qSize; i++) {
                String currWord = q.poll();
                Iterator<String> iter = notVisitedWordSet.iterator();
                while (iter.hasNext()) {
                    String nextWord = iter.next();
                    if (isConnected(currWord, nextWord)) {
                        if (nextWord.equals(endWord)) return depth+1;
                        q.add(nextWord);
                        iter.remove();
                    }
                }
            }
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
