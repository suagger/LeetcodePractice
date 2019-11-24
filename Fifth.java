import java.util.HashSet;

public class Fifth {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0,j = 0;
        int ans = 0;
        while(i <n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j ++));
                ans = Math.max(ans,j - i);
            }else{
                set.remove(s.charAt(i ++));
            }
        }
        return ans;
    }

}
