import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 수
        int t = Integer.parseInt(br.readLine()); // 간선 수

        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < t; i++) { // 간선 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int cnt = 0; // 바이러스 감염 수 계산
        Queue<Integer> que = new LinkedList<>();
        int[] vis = new int[n + 1]; // 방문여부 체크
        que.add(1); // 1번 노드부터 방문
        vis[1] = 1;
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nxt : graph[cur]) {
                if (vis[nxt] == 0) {
                    vis[nxt] = 1;
                    cnt++;
                    que.add(nxt);
                }
            }
        }

        System.out.println(cnt);
    }
}
