//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//// 사실 array list랑 linked list 시간복잡도 똑같
//
//
//public class SWExpert_1230 {
//
//	
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	
//		
//		for(int test_case = 1; test_case <= 10; test_case++)
//		{
//
//			int N = Integer.parseInt(br.readLine());
//			Node head = null, end = null;
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			head = new Node(st.nextToken());
//			Node curNode = head;
//			while(st.hasMoreTokens()) {
//				Node nextNode = new Node(st.nextToken());
//				curNode.next = nextNode;
//				nextNode.prev = curNode;
//				curNode = nextNode;
//			}
//			end = curNode;
//
//			int M = Integer.parseInt(br.readLine());
//			
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			
//			
//			while(st.hasMoreTokens()) {
//				String command = st.nextToken();
//				
//				if(command == "I") {
//					
//				} else if(command == "D") {
//					
//				} else if(command == "A") {
//					
//				} else {
//					System.out.print("unexpected input");
//				}
//				
//			}
//			
//
//			
//		}
//			
//			
//
//
//		
//		
//	}
//	
//	static class Node {
//		String code;
//		Node prev;
//		Node next;
//		
//		Node(String code) {
//			this.code = code;
//		}
//		
//		void insert(Node newNodesHead) {
//			
//		}
//		
//		void delete
//	}
//	
//	
////	static class LinkedList {
////		Node head;
////		Node[] nodeArr;
////		
////		LinkedList() {
////			nodeArr = new Node[]
////		}
////	}
//	
//	
//	
//}
//
//
