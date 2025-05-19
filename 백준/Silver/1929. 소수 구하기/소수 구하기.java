import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] prime = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            prime[i] = i;
        }
        
        for (int i = 2; i <= N; i++) {
            if (prime[i] == 0) continue;
            
            for (int j = 2; j <= N / i; j++) {
                prime[i * j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (prime[i] == 0) continue;
            System.out.println(prime[i]);
        }
        
		sc.close();
	}
}
