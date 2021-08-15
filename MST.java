import java.util.Arrays;
import java.util.Scanner;
 
public class MST {
	public static boolean[] mstSet;  //if vertice in MST or not
	public static int[] lowCost;
	public static int[] parent;
	public static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		for (int i=0; i<E; i++) {
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			int cost = sc.nextInt();
			graph[bv][ev] = cost;
			graph[ev][bv] = cost;
		}
		parent = new int[V];
		mstSet = new boolean[V];
		lowCost = new int[V];
		Arrays.fill(parent,-1);
		Arrays.fill(lowCost, Integer.MAX_VALUE);
		lowCost[0] = 0;
		while (true) {
			int next = findNext();
			if (next==-1) {
				break;   //no next vertice
			}
			mstSet[next] = true;
			//find all neighbor edge update lowCost and parent table
			for (int i=0; i<V; i++) {
				if (mstSet[i]==false 
						&& graph[next][i]!=0 
						&& lowCost[i]>graph[next][i]) {
					lowCost[i] = graph[next][i];
					parent[i] = next;
				}
			}
		}
		for (int i=1; i<V; i++) {
			System.out.println(i+" "+parent[i]+" "+lowCost[i]);
		}
 
	}
 
	public static int findNext() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i=0; i<V; i++) {
			if (mstSet[i]==false && lowCost[i]<min) {
				min = lowCost[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
 
