import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWExpert_1221_1 {
	
	static String[] inString = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[1]);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] inInt = new int[N];
			
			for(int i = 0; i < N; i++) {
				String w = st.nextToken();
				if(w.equals(inString[0])) inInt[i] = 0;
				else if(w.equals(inString[1])) inInt[i] = 1;
				else if(w.equals(inString[2])) inInt[i] = 2;
				else if(w.equals(inString[3])) inInt[i] = 3;
				else if(w.equals(inString[4])) inInt[i] = 4;
				else if(w.equals(inString[5])) inInt[i] = 5;
				else if(w.equals(inString[6])) inInt[i] = 6;
				else if(w.equals(inString[7])) inInt[i] = 7;
				else if(w.equals(inString[8])) inInt[i] = 8;
				else inInt[i] = 9;
			}
			
			Arrays.sort(inInt);
			
			System.out.println("#" + test_case);

			for(int i = 0; i < N; i++) {
				System.out.printf("%s", inString[inInt[i]]);
				if(i != N-1) System.out.printf(" ");
				else System.out.printf("\n");
			}
			
		}			

		
		
	}
	
}
