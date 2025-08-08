import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] height = new int[W];
		for (int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int[] leftMax = new int[W];
		int[] rightMax = new int[W];

		// 왼쪽 최대값 계산
		leftMax[0] = height[0];
		for (int i = 1; i < W; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}

		// 오른쪽 최대값 계산
		rightMax[W - 1] = height[W - 1];
		for (int i = W - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}

		// 빗물 계산
		int sum = 0;
		for (int i = 1; i < W - 1; i++) {
			int water = Math.min(leftMax[i], rightMax[i]) - height[i];
			if (water > 0) {
				sum += water;
			}
		}

		System.out.println(sum);
	}
}
