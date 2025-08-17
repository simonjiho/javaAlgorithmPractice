import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class SWExpert_10726 {

	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int TC = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= TC; test_case++)
		{

			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int nbits = (1 << N) - 1;
			boolean lastNbitAllOne = (M & nbits) == nbits;

			String result = lastNbitAllOne ? "ON" : "OFF";
			System.out.println("#" + test_case + " " + result);
			
		}
			
			


		
		
	}
	
}


