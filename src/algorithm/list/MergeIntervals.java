package algorithm.list;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qun.chen on 27/5/17.
 */
public class MergeIntervals {

    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 1. sort the intervals by first part
     * 2. loop the list, if the next start is earlier than end, merge it, update the end with max between current end time and next end time
     * 3. start the new merge if no more intersections
     * O(n)
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int start = 0;
        int end = 0;
        List<Interval> result = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ) {
            start = intervals.get(i).start;
            end = intervals.get(i).end;
            int j = i + 1;
            while (j < intervals.size() && intervals.get(j).start <= end) {
                end = Math.max(intervals.get(j).end, end);
                j++;
            }
            i = j;
            Interval newInterval = new Interval(start, end);
            result.add(newInterval);
        }

        return result;
    }
}
