import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int j = 1;
            if (gender == 1) {
                while (idx * j <= N) {
                    arr[idx * j] = arr[idx * j] == 0 ? 1 : 0;
                    j++;
                }
            } else {
                arr[idx] = arr[idx] == 0 ? 1 : 0;
                while (idx - j >= 1 && idx + j <= N) {
                    if (arr[idx - j] != arr[idx + j]) break;
                    arr[idx - j] = arr[idx - j] == 0 ? 1 : 0;
                    arr[idx + j] = arr[idx + j] == 0 ? 1 : 0;
                    j++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
