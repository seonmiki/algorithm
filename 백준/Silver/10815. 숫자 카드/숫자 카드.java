import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		
		arr.sort(null);		
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			System.out.print(binarySearch(sc.nextInt()) + " ");
		}
		
		sc.close();
	}
	
	static int binarySearch(int key) {
		int left = 0;
		int right = arr.size() - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr.get(mid) == key) {
				return 1;
			}
			if (arr.get(mid) < key) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return 0;
	}
}
