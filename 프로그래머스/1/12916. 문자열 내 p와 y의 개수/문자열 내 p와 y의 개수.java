class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') pCnt += 1;
            else if (c == 'y' || c == 'Y') yCnt += 1;
        }

        return pCnt == yCnt ? true : false;
    }
}