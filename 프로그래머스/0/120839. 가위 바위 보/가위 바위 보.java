class Solution {
    public String solution(String rsp) {
        String answer = "";
        for (int i = 0; i < rsp.length(); i++) {
            answer += run(rsp.charAt(i));
        }
        return answer;
    }
    
    String run(char input) {
        if (input == '2') return "0";
        else if (input == '0') return "5";
        return "2";
    }
}