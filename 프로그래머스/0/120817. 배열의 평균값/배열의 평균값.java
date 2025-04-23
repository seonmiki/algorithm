class Solution {
    public double solution(int[] numbers) {
        double sum = 0;
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }
        return sum / size;
    }
}