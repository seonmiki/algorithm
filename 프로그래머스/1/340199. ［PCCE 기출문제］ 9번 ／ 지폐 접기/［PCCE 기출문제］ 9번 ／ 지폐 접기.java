class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int ws = wallet[0] < wallet[1] ? wallet[0] : wallet[1];
        int wl = wallet[0] > wallet[1] ? wallet[0] : wallet[1];
        while (true) {
            int bs = bill[0] < bill[1] ? bill[0] : bill[1];
            int bl = bill[0] > bill[1] ? bill[0] : bill[1];
            if (bs <= ws && bl <= wl) break;
            if (bl == bill[0]) bill[0] /= 2;
            else bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}