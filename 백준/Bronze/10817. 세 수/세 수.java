import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
	}
}
