import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
class Solution
{
	public static void main(String args[]) throws Exception
	{BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	for(int i=1;i<=10;i++) {
	
		int N= Integer.parseInt(br.readLine());
		int[] arr= new int[100];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int k=0;k<100;k++) {
			arr[k]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int k=0;k<N;k++) {
			arr[99]--;
			arr[0]++;
			Arrays.sort(arr);
			
		}
		int num =arr[99]-arr[0];
		System.out.println("#"+i+" "+num);
		
	}
		
 }		
}