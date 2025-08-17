import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_1288 {

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			
			int N = Integer.parseInt(br.readLine());
			
			int found = 0;
			int k = 1;
			while (found != 1023) {
				int num = N * k;
				while(num != 0) {
					int remainder = num % 10;
					num /= 10;
					found |= 1 << remainder;
				}
				k++;
			}

			
			System.out.println("#" + test_case + " " + N*(k-1));
			
		}
			
			


		
		
	}
	
}


