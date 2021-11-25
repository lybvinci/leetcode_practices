import java.util.Arrays;
import java.util.Comparator;

//41.94%
public class Merge074 {

    public int[][] merge(int[][] intervals) {
      if (intervals.length <= 1) {
        return intervals;
      }
      Arrays.sort(intervals, new Comparator<int[]>(){
        @Override
        public int compare(int[] left, int[] right) {
          return left[0] - right[0];
        }
      });
      int[][] ret = new int[intervals.length][2];
      int index = 0;
      int[] cur = intervals[0];
      for (int i = 1; i < intervals.length; i++) {
        if (intervals[i][0] >= cur[0] && intervals[i][1] <= cur[1]) {
          continue;
        } else if (intervals[i][0] >= cur[0] && intervals[i][0] <= cur[1] && intervals[i][1] > cur[1]) {
          cur[1] = intervals[i][1];
        } else if (intervals[i][0] > cur[1]) {
          ret[index][0] = cur[0];
          ret[index][1] = cur[1];
          index++;
          cur = intervals[i];
        }
      }
      int[][] res = new int[index+1][2];
      for (int i = 0; i < index; i++) {
        res[i][0] = ret[i][0];
        res[i][1] = ret[i][1];
      }
      res[index][0] = cur[0];
      res[index][1] = cur[1];
      return res;
    }

    public static void main(String[] args) {
      Merge074 m = new Merge074();
      //[[1,3],[2,6],[8,10],[15,18]]
      m.merge(new int[][]{{1,3}, {2,6}, {8, 10}, {15, 18}});
    }
}
