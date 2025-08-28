import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWExpert_14510 {


	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			int tree_max = 0;

			
			String[] input = br.readLine().split(" ");
			for(int i=0;i < N;i++) {
				int value = Integer.parseInt(input[i]);
				tree_max = Math.max(value, tree_max);
				trees[i] = Integer.parseInt(input[i]);
			}
			
			int leastOneRequired = 0;
			int treeReq = 0;
			
			for(int i=0;i < N;i++) {
				int a = tree_max - trees[i];
				treeReq += a;
				if(a%2 == 1) leastOneRequired++;
			}
			

			int days = 0;
	
			while(true) {
				
				int oddDayCnt = (days+1)/2; // 1씩 자람
				int evenDayCnt = days/2; // 2씩 자람
				
				int totalCnt = oddDayCnt + (evenDayCnt*2);
				
				if(totalCnt >= treeReq && leastOneRequired <= oddDayCnt) break;
				days++;
			}
		
			
			
			
			

			
			System.out.println("#" + test_case + " " + days);
			
		}
			
			


		
		
	}
	

}


