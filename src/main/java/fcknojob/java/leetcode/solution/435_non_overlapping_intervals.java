package fcknojob.java.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        final int INTERVALS_SIZE = intervals.length;

        if (INTERVALS_SIZE == 0) return 0;

        // Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        Arrays.sort(intervals,
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.end - o2.end;
                    }
                });
        int maxNonOverlappingIntervalsSize = 1;
        int currentEnd=intervals[0].end;

        for (Interval currentInterval: intervals) {
            if (currentInterval.start < currentEnd) continue;
            currentEnd = currentInterval.end;
            maxNonOverlappingIntervalsSize++;
        }

        int minimumRemovableIntervalsSize = INTERVALS_SIZE - maxNonOverlappingIntervalsSize;

        return minimumRemovableIntervalsSize;
    }
}
