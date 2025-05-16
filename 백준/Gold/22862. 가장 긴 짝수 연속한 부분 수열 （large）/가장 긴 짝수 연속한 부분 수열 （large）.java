import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int oddCnt = 0;
		int maxLen = 0;
		
		while (end < N) {
			if (arr[end] % 2 == 0) {
				end++;
			} else {
				if (oddCnt < K) {
					oddCnt++;
					end++;
				} else {
					if (arr[start] % 2 == 1) {
						oddCnt--;
					}
					start++;
				}
			}
			//현재 구간에서 짝수의 개수 = (end - start - oddCnt)
			maxLen = Math.max(maxLen, end - start - oddCnt);
		}

		System.out.println(maxLen);
	}
}
