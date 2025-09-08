import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] left = new int[N + 1]; // left[i] = i보다 키 큰 사람이 왼쪽에 몇 명
        for (int i = 1; i <= N; i++) left[i] = Integer.parseInt(st.nextToken());

        List<Integer> line = new ArrayList<>();
        // 키 큰 사람부터 줄에 삽입
        for (int i = N; i >= 1; i--) {
            line.add(left[i], i); // 왼쪽에 있어야 할 큰 사람 수 = 삽입 위치
        }

        StringBuilder sb = new StringBuilder();
        for (int x : line) sb.append(x).append(' ');
        System.out.print(sb.toString());
    }
}
