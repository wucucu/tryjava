package fcknojob.java.leetcode._279_perfect_squares;

import java.util.*;

/*
 * BFS
 * try Queue<>
 */
class Solution {

    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> squares = getSquares(n);
        boolean[] isVisited = new boolean[n+1];

        q.add(n);
        for (int i = 0; i < n; i++) isVisited[i] = false;
        isVisited[n] = true;

        int resultLevel = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            resultLevel++;
            for (int i = 0; i < qSize; i++) {
                int currInt = q.poll();
                for (int square: squares) {
                    int remainInt = currInt - square;
                    if (remainInt == 0) {
                        return resultLevel;
                    } else if (remainInt < 0) {
                        break;
                    } else if (!isVisited[remainInt]){
                        q.add(remainInt);
                        isVisited[remainInt] = true;
                    }
                }
            }
        }

        return n;

    }

    static private List<Integer> getSquares(int n) {
        List<Integer> r = new ArrayList<>();

        int i = 1;
        int iSquare = 1;

        while (iSquare <= n) {
            r.add(iSquare);
            i++;
            iSquare = i * i;
        }

//        Collections.reverse(r);

        return r;
    }

}
