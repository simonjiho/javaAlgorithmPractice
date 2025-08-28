import java.io.BufferedReader;
import java.io.InputStreamReader;



public class SWExpert_25111 {
	
	static final long MOD = 1000000009L;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
//			System.out.println("test case" + test_case);

			
			long ans;
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);

			int a = N / K;
			int b = M / (K-1);
			
			
			
			if (M == 0) {ans = 0;}
			else if(a > b) { 
				ans = M; 
			}
			else {
				
				int x = N - M;
				int y = (K-1)*x;
				int z = M - y;
				
				int q = z/K;
				int r = z%K;
				
//				System.out.println("x: " + x);
//				System.out.println("y: " + y);
//				System.out.println("z: " + z);
//				System.out.println("q: " + q);
//				System.out.println("r: " + r);

				

				if (q > 40) {
//				    System.out.println("big q");
				    long num = 1L;
				    while (q > 0) {
				        if (q > 40) {
				            num = (num * ((1L << 40) % MOD)) % MOD; // 40씩
				            q -= 40;
				        } else { // 1..40 남은 구간
				            num = (num * ((1L << q) % MOD)) % MOD;  // ← 고쳤음
				            q = 0;
				        }
				    }
				    long tmp = ( ( (2L * K) % MOD) * ((num - 1 + MOD) % MOD) ) % MOD;
				    ans = (tmp + r + y) % MOD;
				} else {
//				    System.out.println("small q");
				    long part = ((1L << (q + 1)) - 2L) % MOD;      // ← long 시프트
				    if (part < 0) part += MOD;
				    long tmp = ((K % MOD) * part) % MOD;
				    ans = (tmp + r + y) % MOD;
				}


			}


	

			System.out.println(ans % (1000000009));
			
		}			

		
		
	}

	
}


