
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWExpert_1206 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			int[] height = new int[N];
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(s[i]);
			}
			
			int ans = 0;
			for(int i=2; i < N-2; i++) {
				int h = height[i];
				int l = Math.max(height[i-1], height[i-2]);
				int r = Math.max(height[i+1], height[i+2]);
				
				ans += Math.max(0,h - Math.max(l, r));
				
			}
			

			System.out.println("#" + test_case + " " + ans);
		}
		
		
	}
}
