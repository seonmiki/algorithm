class Solution {
    public int[] solution(int[] array) {
        int maxValue = -999;
        int maxIdx = -1;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIdx = i;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = maxValue;
        answer[1] = maxIdx;
        return answer;
    }
}