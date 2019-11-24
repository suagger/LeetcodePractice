import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Second {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals,new Comparator<int []>() {
            public int compare(int [] o1,int [] o2){
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length - 1; i ++){
            if(intervals[i + 1][0] <= intervals[i][1]){
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i + 1][1],intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }

        list.add(intervals[intervals.length - 1]);
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i ++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        return res;

    }

}
