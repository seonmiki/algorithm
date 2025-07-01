import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.charAt(i));
        }
        Collections.sort(arr);
        
        String ret = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            ret += arr.get(i) + "";
        }
        return ret;
    }
}