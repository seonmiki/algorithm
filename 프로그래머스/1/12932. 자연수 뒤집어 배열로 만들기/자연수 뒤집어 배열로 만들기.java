import java.util.*;

class Solution {
    public int[] solution(long n) {
        Queue<Integer> queue = new LinkedList<>();
        while (n / 10 > 0) {
            queue.add((int) (n % 10));
            n /= 10;
        }
        queue.add((int)n);
        
        int size = queue.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}