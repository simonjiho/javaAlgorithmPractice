import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
 
 
public class SWExpert_1251_1 {
 
//  static int N;
//  
//  static long[][] dist;
     
     
     
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
 
            int N = Integer.parseInt(br.readLine());
            long[] posX = new long[N];
            long[] posY = new long[N];
            long[] minD = new long[N];
//          int[] minU = new int[N];
            Arrays.fill(minD, Long.MAX_VALUE);
//          Arrays.fill(minU, -1);
             
            boolean[] visited = new boolean[N];
             
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 0;i < N; i++) {
                posX[i] = Integer.parseInt(st.nextToken());
                posY[i] = Integer.parseInt(st2.nextToken());
            } 
             
            double E = Double.parseDouble(br.readLine());
             
            minD[0] = 0;
             
            PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((a,b) -> Long.compare(minD[a], minD[b]) );
            for(int i = 0; i < N; i++) pq.add(i);
             
            long ans = 0;
            for(int i = 0; i < N; i++) {
                 
                int u = -1; // closest vertex
                long shortestE = Long.MAX_VALUE;
                for(int j = 0; j < N; j++) {
                    if(visited[j] || minD[j] >= shortestE) continue;
                     
                    shortestE = minD[j];
                    u = j;
                }
                 
                visited[u] = true;
                ans+=minD[u];
                 
                for(int v = 0; v < N; v++) {
                    if(visited[v]) continue;
                     
                    long dx = posX[u] - posX[v];
                    long dy = posY[u] - posY[v];
                     
                    long d = dy*dy + dx*dx;
                    if(minD[v] > d) {
                        minD[v] = d;
                    }
                }
            }
 
             
             
             
             
             
            System.out.println("#" + test_case + " " + Math.round(ans*E));
             
        }
             
             
 
         
         
         
    }
 
     
 
}