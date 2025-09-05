import java.util.Scanner;



public class SWExpert_25111 {
	

    static final long MOD = 1000000009L;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		

		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			
			long ans;
			

			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

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
				

                if (q > 40) {
                    long num = 1L;
                    int rem = q;
                    while (rem > 0) {
                        if (rem > 40) {
                            num = (num * ((1L << 40) % MOD)) % MOD;
                            rem -= 40;
                        } else {
                            num = (num * ((1L << rem) % MOD)) % MOD;
                            rem = 0;
                        }
                    }
                    long tmp = ((2L * K) % MOD) * ((num - 1 + MOD) % MOD) % MOD;
                    ans = (tmp + r + y) % MOD;
                } else {
                    long part = ((1L << (q + 1)) - 2L) % MOD;
                    if (part < 0) part += MOD;
                    long tmp = ((K % MOD) * part) % MOD;
                    ans = (tmp + r + y) % MOD;
                }


			}

			System.out.println(ans % MOD);
			
		}			

		
		
	}

	
}


