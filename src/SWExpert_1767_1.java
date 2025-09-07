import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 
 
public class SWExpert_1767_1 {

    static int[][] cells;
    static int N;
	static int coreCnt;
	static Core[] cores;
	static int maxConnectedCores;
	static int minWireSum;

	static int R = 0, L = 1, D = 2, U = 3;

	
    public static void main(String args[]) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc<=T; tc++) {
    		
        	N = Integer.parseInt(br.readLine());	
    		cells = new int[N][N];
    		cores = new Core[12];
    		coreCnt = 0;
    		maxConnectedCores = 0;
    		minWireSum = Integer.MAX_VALUE;
    		
    		for(int i=0;i<N;i++) {
    			StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j=0;j<N;j++) {
        			cells[i][j] = Integer.parseInt(st.nextToken());
        			if(cells[i][j] == 1) {
        				cores[coreCnt++] = new Core(i, j);
        			}
        		}
    		}
    		
    	
    		// 코어 가능한 방향(다른 코어에 방해 안받는 방향) + 그 방향의 wire 구하기
    		for(int i = 0; i < coreCnt; i++ ) {
    			Core core = cores[i];
	    		for(int j = i+1; j < coreCnt; j++ ) {
	    			Core core2 = cores[j];
    				if(core.r == core2.r) {
    					if (core.c < core2.c) {
    						core.isPossibleDir[R] = false;
    						core2.isPossibleDir[L] = false;
    					}
    					else {
    						core.isPossibleDir[L] = false;
    						core2.isPossibleDir[R] = false;
						}
    				}
    				else if(core.c == core2.c) {
    					if (core.r < core2.r) {
    						core.isPossibleDir[D] = false;
    						core2.isPossibleDir[U] = false;
    					}
    					else {
    						core.isPossibleDir[U] = false;
    						core2.isPossibleDir[D] = false;
    					}
					}
    				
    			}
    			
    			if(core.isPossibleDir[R]) core.wireLength[R] = N-1-core.c;
    			if(core.isPossibleDir[L]) core.wireLength[L] = core.c;
    			if(core.isPossibleDir[D]) core.wireLength[D] = N-1-core.r;
    			if(core.isPossibleDir[U]) core.wireLength[U] = core.r;

    			
    		}
    		
    		
    		
    		
    		dfs(0,0, 0);
    		
    		System.out.println("#"+tc+" "+minWireSum);
    		
    		
    	}
    }
    
    static void dfs(int coreIdx, int wireSum, int connectedCores) {
    	if(coreIdx == coreCnt) {
    		if (maxConnectedCores < connectedCores) {
    			maxConnectedCores = connectedCores;
    			minWireSum = wireSum;
    		} else if(maxConnectedCores == connectedCores) {
    			minWireSum = Math.min(wireSum, minWireSum);
    		}
    		return;
    	}
    	Core core = cores[coreIdx];
    	
    	if (core.onEdge()) {
    		dfs(coreIdx+1, wireSum, connectedCores+1);
    	}
    	else {
        	// not connected
	    	core.wireDir = -1;
    		dfs(coreIdx+1, wireSum, connectedCores);
	    	outer:for(int i = 0; i < 4; i++) {
	    		if(!core.isPossibleDir[i]) continue;
	    		core.wireDir = i;
	    		int r1 = core.r, c1 = core.c, d1 = core.wireDir;
	    		
	    		for(int j = 0; j < coreIdx; j++ ) {
	    			if(cores[j].onEdge()) continue;
	    			int r2 = cores[j].r, c2 = cores[j].c, d2 = cores[j].wireDir;
	    			if(wireCross(r1,c1,d1,r2,c2,d2)) continue outer;
	    		}
	    		
	    		dfs(coreIdx+1, wireSum+core.wireLength[i], connectedCores+1);
	    	}
	    		    	
    	}
    	

    			
    }
     

     
    
    static class Core {
    	int r;
    	int c;
    	int wireDir = -1;
    	boolean[] isPossibleDir = new boolean[4]; // r l d u
    	int[] wireLength = new int[4]; // r l d u
    	
    	Core(int r, int c) {
    		this.r = r; this.c = c;
    		for(int i = 0; i<4; i++) {
    			this.isPossibleDir[i] = true;
    		}
    	}
    	
        boolean onEdge() {
        	return r == 0 || r == N-1 || c == 0 || c == N-1;
    	}
    	
    }
 
    static boolean wireCross(int r1, int c1, int d1, int r2, int c2, int d2) {
    	// 가정: r1 != r2 && c1 != c2
    	
    	if( d1 == -1 || d2 == -1 ) return false;
    	
    	if ( r1 < r2 && c1 < c2 ) {
    		if ((d1 == R && d2 == U) || (d1 == D && d2 == L)) return true;
    		else return false;
    	} else if ( r1 < r2 && c1 > c2) {
    		if ((d1 == R && d2 == D) || (d1 == U && d2 == L)) return true;
    		else return false;
    	} else if ( r1 > r2 && c1 > c2) {
    		if ((d1 == U && d2 == R) || (d1 == L && d2 == D)) return true;
    		else return false;
    	} else { // r1 > r2 && c1 < c2
    		if ((d1 == D && d2 == R) || (d1 == L && d2 == U)) return true;
    		else return false;
    	}
    	
    }
     
     
}