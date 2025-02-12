import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int ans=0;
	public static void bfs(int[] a) {
		Queue<int[]> qu =new LinkedList<>();

		qu.offer(new int[] {1,0});
		
		Loop:while(!qu.isEmpty()) {
			  int[] temp=qu.poll();
			  int max=0;
			for(int i=6;i>=1;i--) {
				if(temp[0]+i>100) {
					continue;
				}else if(temp[0]+i==100) {
					ans=temp[1]+1;
					break Loop;
				}
					
					
			    if(a[temp[0]+i]>0) {
			    	qu.offer(new int[] {a[temp[0]+i],temp[1]+1});
			    }else {max=Math.max(max, i);}
			}
		   
			if(max>0)
				qu.offer(new int[] {temp[0]+max,temp[1]+1});

	      }
		
	}
	

	 public static void main(String args[]) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     StringTokenizer st =new StringTokenizer(br.readLine());
    
     int N=Integer.parseInt(st.nextToken());
     int M=Integer.parseInt(st.nextToken());
     
     int[] arr = new int[101];
           
     for(int i=0;i<N+M;i++) {
    	 st =new StringTokenizer(br.readLine());
    	 int u =Integer.parseInt(st.nextToken());
    	 int v =Integer.parseInt(st.nextToken());
    	 arr[u]=v;
     }
     
     

     
     bfs(arr);
     System.out.println(ans);
     
     
   }	 
}
