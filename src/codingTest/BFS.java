package codingTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public static void main(String[] args) {
		int[][] arr = {{},{2,4},{5,6},{},{7},{},{},{}};
		bfs(1,arr);
	}
	
	
	public static int[] bfs(int start,int[][] arr) {
		int[] result = {};
		boolean[] chk = new boolean[arr.length];	
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		chk[start]= true;
		
		while(!que.isEmpty()) {
			int node = que.poll();
			System.out.println(node);
			for(int i=0;i<arr[node].length;i++) {
				
				if(!chk[arr[node][i]]) {
					que.add(arr[node][i]);
					chk[arr[node][i]] = true;
				}
			}

		}
		
		
		
		return result;
	}
}
