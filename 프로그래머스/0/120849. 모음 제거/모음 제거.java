class Solution {
    public String solution(String my_string) {
        String answer = "";
        String key = "aeiou";
        for (int i = 0; i < my_string.length(); i++) {
            String cur = my_string.charAt(i) + "";
            if (!key.contains(cur)) {
                answer += cur;
            }
        }
        return answer;
    }
}