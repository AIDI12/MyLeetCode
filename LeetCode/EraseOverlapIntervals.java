package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * @author AD
 *
 */
public class EraseOverlapIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.end - o2.end;
			}
		});
		int length = intervals.length;
		int count = 1;
		int last = 0;
		for (int i = 1; i < length; i++) {
			if (intervals[last].end <= intervals[i].start) {
				count++;
				last = i;
			}
		}
		return length - count;
	}
}

class Interval {
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