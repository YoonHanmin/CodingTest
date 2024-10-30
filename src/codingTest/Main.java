package codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
	public static void main(String[] args) throws Exception {
		new Main().solution_nm();
	}
	
//	15649[S3] N과M (1)
	public void solution_nm() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
    
        boolean[] chk = new boolean[N];
        backtracking(N, M,0,chk,arr);
	}
	
	public static void backtracking(int N,int M,int depth,boolean[] chk,int[] arr) {
		
		if(depth == M) {
			for(int a : arr) {
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<N;i++) {
			if(!chk[i]) {
				chk[i] = true;
				arr[depth] = i+1;
			backtracking(N,M,depth+1,chk,arr);
				chk[i] = false;
			}
		}
		
	}
	
//	2606[S3] 바이러스
	public void solution_virus() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int M = Integer.parseInt(br.readLine());
        boolean[] chk = new boolean[N+1];
        
        for(int i =0;i<M;i++) {
        	String str = br.readLine();
        	st = new StringTokenizer(str);
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a][b] = 1;
        	arr[b][a] = 1;
        }
		
        int answer = dfs_v(arr,chk,1);
        System.out.println(answer);
        
	}
	private static int dfs_v(int[][] arr,boolean[] chk,int num) {
		
		chk[num] = true;
		int count = 0;
		for(int i =1;i<arr[num].length;i++) {
		if(arr[num][i]==1 && !chk[i]) {
			count ++;
			count += dfs_v(arr,chk,i);
		}
		}
		return count;
	}
	
	
//	1260 [S2] BFS와 DFS
	public void solution_BFSDFS() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int a, b;
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a - 1][b - 1] = 1; // 0-based index
            arr[b - 1][a - 1] = 1; // 0-based index
        }

        boolean[] chk = new boolean[N];
        dfs(start - 1, arr, chk); // DFS 호출 (0-based index)
        System.out.println();
        bfs(start - 1, arr); // BFS 호출 (0-based index)
    }

    private static void dfs(int start, int[][] arr, boolean[] chk) {
        chk[start] = true;
        System.out.print((start + 1) + " "); // 1-based index 출력

        for (int i = 0; i < arr.length; i++) {
            if (arr[start][i] == 1 && !chk[i]) {
                dfs(i, arr, chk);
            }
        }
    }

    private static void bfs(int start, int[][] arr) {
        boolean[] chk = new boolean[arr.length];
        Queue<Integer> que = new LinkedList<>();
        chk[start] = true; // 시작 정점 방문 처리
        que.add(start);

        while (!que.isEmpty()) {
            int a = que.poll();
            System.out.print((a + 1) + " "); // 1-based index 출력

            for (int i = 0; i < arr[a].length; i++) { // 0-based index 사용
                if (arr[a][i] == 1 && !chk[i]) {
                    chk[i] = true;
                    que.add(i); // 0-based index로 추가
                }
            }
        }
    }
	
	
	
	public void solution() throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	String str = br.readLine();
	st = new StringTokenizer(str);
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int[] arr = new int[n];
	
	str = br.readLine();
	st = new StringTokenizer(str);
	int idx = 0;
	while(st.hasMoreTokens()) {
		arr[idx] = Integer.parseInt(st.nextToken());
		idx ++;
	}
	int[] sumArr = new int[n+1];
	sumArr[1] = arr[0];
	int sum = 0;
	for(int i=1;i<arr.length;i++) {
		sum = 0;
		
		sumArr[i+1] = sumArr[i]+arr[i];
	}

	int a,b;
	
	for(int i = 0;i<m;i++) {
	
		str = br.readLine();
		st = new StringTokenizer(str);
		
	 a = Integer.parseInt(st.nextToken());
	 b = Integer.parseInt(st.nextToken());
		sum = sumArr[b]-sumArr[a-1];
		System.out.println(sum);
		
	}
	
	}
	
	
	
	
	
	
	
	}
	
