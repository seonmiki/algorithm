import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int[][] arr, tmp;
    static int bomb, width, height;
    static int minRemain;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bomb = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            arr = new int[height][width];

            for (int y = 0; y < height; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < width; x++) {
                    arr[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            minRemain = Integer.MAX_VALUE;
            dropBall(0, arr);
            if (minRemain == Integer.MAX_VALUE) minRemain = 0;
            sb.append("#" + tc + " " + minRemain + '\n');
        }
        
        System.out.println(sb);
    }

    // 구슬 떨어뜨리는 백트래킹
    public static void dropBall(int lev, int[][] board) {
        if (lev == bomb) {
            minRemain = Math.min(minRemain, countBricks(board));
            return;
        }

        for (int x = 0; x < width; x++) {
            int[][] backup = new int[height][width]; // 현재 상태 저장
            copyArray(backup, board);
            
            int y = findFirstBrick(x, board);
            if (y == -1) continue; // 해당 열에 벽돌이 없으면 패스

            explode(y, x, board); // 벽돌 폭발
            applyGravity(board); // 중력 적용
            dropBall(lev + 1, board); // 다음 구슬

            // 원래 상태로 복구
            copyArray(board, backup);
        }
    }

    // DFS로 벽돌 폭발 처리
    public static void explode(int y, int x, int[][] board) {
        if (y < 0 || y >= height || x < 0 || x >= width || board[y][x] == 0) return;

        int range = board[y][x] - 1;
        board[y][x] = 0;  // 현재 벽돌 제거
        
        for (int i = 1; i <= range; i++) {
        	for (int k = 0; k < 4; k++) {
        		int ny = y + dy[k] * i;
        		int nx = x + dx[k] * i;
        		explode(ny, nx, board);
        	}
        }
    }

    // 중력 적용
    public static void applyGravity(int[][] board) {
        for (int x = 0; x < width; x++) {
            Queue<Integer> queue = new LinkedList<>();

            // 벽돌들을 아래에서 위로 탐색하여 큐에 저장
            for (int y = height - 1; y >= 0; y--) {
                if (board[y][x] > 0) {
                    queue.add(board[y][x]);
                    board[y][x] = 0;
                }
            }

            // 큐에서 하나씩 꺼내며 바닥부터 다시 채우기
            int y = height - 1;
            while (!queue.isEmpty()) {
                board[y--][x] = queue.poll();
            }
        }
    }

    // 남아있는 벽돌 개수 세기
    public static int countBricks(int[][] board) {
        int cnt = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (board[y][x] > 0) cnt++;
            }
        }
        return cnt;
    }

    // 특정 열에서 가장 위에 있는 벽돌의 y 좌표 찾기
    public static int findFirstBrick(int x, int[][] board) {
        for (int y = 0; y < height; y++) {
            if (board[y][x] > 0) return y;
        }
        return -1;
    }

    // 배열 복사 함수
    public static void copyArray(int[][] dest, int[][] src) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                dest[y][x] = src[y][x];
            }
        }
    }
}