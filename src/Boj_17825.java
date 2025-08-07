import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 14:20 시작

public class Boj_17825 {

	static int ans = 0;
	static int[] dice = new int[10];
	static Node startNode = new Node(0); // 시작
	static Node endNode = new Node(0); // 도착

	public static void main(String args[]) throws Exception {



		Node curNode = startNode;


		ArrayList<Node> edgeNodes = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			Node node = new Node((i+1)*2);
			if((i+1)%5 == 0 && i+1 != 20) edgeNodes.add(node);
			curNode.next = node;
			curNode = node;
		}
		Node node40 = curNode;
		curNode.next = endNode;


		ArrayList<Node> nodes_bfCenter = new ArrayList<>();


		// -> 13 -> 16 -> 19
		int score_init = 13;
		curNode = new Node(score_init);
		edgeNodes.get(0).next_blue = curNode;
		curNode = createNodes(curNode, 2, 3, score_init);
		nodes_bfCenter.add(curNode);

		// -> 22 -> 24
		score_init = 22;
		curNode = new Node(score_init);
		edgeNodes.get(1).next_blue = curNode;
		curNode = createNodes(curNode, 1, 2, score_init);
		nodes_bfCenter.add(curNode);

		// -> 28 -> 27 -> 26
		score_init = 28;
		curNode = new Node(score_init);
		edgeNodes.get(2).next_blue = curNode;
		curNode = createNodes(curNode, 2, -1, score_init);
		nodes_bfCenter.add(curNode);


		// (19,24,26) -> 25
		Node centerNode = new Node(25);
		for(Node node: nodes_bfCenter) {
			node.next = centerNode;
		}

		// -> 30 -> 35
		curNode = centerNode;
		score_init = centerNode.score;
		curNode = createNodes(curNode, 2, 5, score_init);
		curNode.next = node40; // -> 40


		curNode = startNode;

//		// check 윷놀이 map
//		while(curNode != null) {
//			System.out.println(curNode.score);
//
//			if (curNode.score == 30 && curNode.next_blue != null) curNode = curNode.next_blue;
//			else curNode = curNode.next;
//
//		}




		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		Node[] nodes = {startNode, startNode, startNode, startNode};
		
		dfs(0, 0, nodes);
		
		System.out.println(ans);

	}

	static void dfs(int cnt, int sum, Node[] nodes) {
//		if (cnt == 10) {ans = Math.max(ans, sum); return;}
		if (cnt == 10) {return;}

//		System.out.println("dice thrown #"+(cnt+1));

		for(int i = 0; i < 4; i++) {
			Node[] curNodes = nodes;
			Node prevNode = curNodes[i], curNode = prevNode;
			
//			if(reachedEnd(prevNode)) System.out.println("piece " + i + " reached end");
			if (reachedEnd(prevNode)) {ans = Math.max(ans, sum);continue;}
//			if (reachedEnd(prevNode)) {continue;}
			
			int move = dice[cnt] + ((curNode.next_blue == null) ? 0 : -1);

			if (curNode.next_blue != null) {
				curNode = curNode.next_blue;
			}

			for(int j = 0; j < move; j++) {
				if(curNode != null) curNode = curNode.next;
			}
			
			boolean alreadyOccupied = false;
			for(int j = 0; j < 4; j++) {
				if (reachedEnd(curNodes[j])) continue;
				if (curNodes[j] == curNode) alreadyOccupied = true;
			}
			if (alreadyOccupied) {
//				ans = Math.max(ans, sum);
				continue;
			}
			
			
			prevNode.pieceOn = false;
			if (!reachedEnd(curNode)) curNode.pieceOn = true;
			int scoreGot = (curNode != null) ? curNode.score : 0;
		
			
			ans = Math.max(ans, sum+scoreGot);

//			System.out.println( sum + " + " + scoreGot + " = " + (sum + scoreGot));
			
			curNodes[i] = curNode;
			dfs(cnt+1, sum+scoreGot, curNodes);
			
			// back track
			if (curNode != null) curNode.pieceOn = false;
			prevNode.pieceOn = true;
			curNodes[i] = prevNode;
		}





	}
	
	static boolean reachedEnd(Node node) {
		return (node == null || node == endNode) ;
	}

	static Node createNodes(Node curNode, int r, int n, int initS) {
		int score = initS;
		for(int i = 0; i < r; i++) {
			score += n;
			Node node = new Node(score);
			curNode.next = node;
			curNode = node;
		}
		return curNode;
	}

	static class Node {
		int score;
		Node next;
		Node next_blue;
		boolean pieceOn = false;

		Node(int score) {
			this.score = score;
		}

		Node(int score, Node next) {
			this.score = score;
			this.next = next;
		}
	}

}