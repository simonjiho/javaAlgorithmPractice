import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_4008 {

	static int N;
	static int maxVal;
	static int minVal;
	static int[] operator = new int[4];
	static int[] nums;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			maxVal = Integer.MIN_VALUE;
			minVal = Integer.MAX_VALUE;
			
			// + - * /
			String[] input1 = br.readLine().split(" ");
			for(int i=0;i<4;i++) operator[i] = Integer.parseInt(input1[i]);
			
			nums = new int[N];
			String[] input2 = br.readLine().split(" ");
			for(int i=0;i<N;i++) nums[i] = Integer.parseInt(input2[i]);
					
			dfs(1, nums[0]);
			
			System.out.println("#" + test_case + " " + (maxVal-minVal));
			
			
		}
			
			
		
	}
	
	static void dfs(int cnt, int num) {
		if (cnt == N) {
			maxVal = Math.max(maxVal, num);
			minVal = Math.min(minVal, num);
		}
		
		if(operator[0] > 0) {
			operator[0]--;
			dfs(cnt+1, num + nums[cnt]);
			operator[0]++;
		}
		if(operator[1] > 0) {
			operator[1]--;
			dfs(cnt+1, num - nums[cnt]);
			operator[1]++;
		}
		if(operator[2] > 0) {
			operator[2]--;
			dfs(cnt+1, num * nums[cnt]);
			operator[2]++;
		}
		if(operator[3] > 0) {
			operator[3]--;
			dfs(cnt+1, num / nums[cnt]);
			operator[3]++;
		}
	}
	
	
}


