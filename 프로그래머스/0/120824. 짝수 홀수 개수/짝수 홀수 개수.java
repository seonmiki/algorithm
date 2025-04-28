class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int a = 0;
        int b = 0;
        for (int i = 0; i < size; i++) {
            if (num_list[i] % 2 == 0) a++;
            else b++;
        }
        int[] answer = new int[2];
        answer[0] = a;
        answer[1] = b;
        return answer;
    }
}