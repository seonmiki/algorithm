class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (int a = 0; a < s1.length; a++) {
            for (int b = 0; b < s2.length; b++) {
                if (s1[a].equals(s2[b])) answer++;
            }
        }
        return answer;
    }
}