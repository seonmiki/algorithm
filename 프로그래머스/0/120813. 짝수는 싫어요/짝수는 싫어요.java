class Solution {
    public int[] solution(int n) {
        int size = n /2 ;
        if (n % 2 == 1) size++;
        int[] answer = new int[size];
        int idx = 0;
        for (int i = 1; i <= n; i += 2) {
            answer[idx++] = i;
        }
        return answer;
    }
}