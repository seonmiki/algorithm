import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = Arrays.stream(stones).max().getAsInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    public boolean canCross(int[] stones, int k, int people) {
        int count = 0;
        for (int stone : stones) {
            if (stone - people < 0) {
                count++;
                if (count >= k) return false;
            } else {
                count = 0;
            }
        }
        return true;
    }
}