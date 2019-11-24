import java.util.ArrayList;
import java.util.List;

public class Third {
    public String getPermutation(int n, int k) {
        StringBuilder  sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int[] cal = new int[n + 1];
        cal[0] = 1;
        int x = 1;;
        for(int i = 1; i <= n; i ++){
            list.add(i);
            x = x * i;
            cal[i] = x;
        }
        k -= 1;
        int index;
        for(int i = n - 1; i >= 0; i --){
            index = k / cal[i];
            sb.append(list.remove(index));
            k -= index * cal[i];
        }
        return sb.toString();
    }

}
