package codingTest;

public class DFS {
	
	public static void main(String[] args) {
		int[][] map = {{1,0,1,1,1},{1,0,1,0,1} ,{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		solution_���Ӹ�ã��(map);
		
	}
	
	
	
	public static int solution_���Ӹ�ã��(int[][] maps) {
		int answer = 0;

		
		return answer;
	}
	
	public void dfs_game(int[][] maps,int x,int y,int count) {
		
		if(x<maps.length-1 && maps[x+1][y] != 0) {
			maps[x+1][y] = 0;
			dfs_game(maps,x+1,y,count +1);
			maps[x+1][y] = 1;
		}
		
		if(x<maps.length-1 && maps[x][y+1] != 0) {
			maps[x][y+1] = 0;
			dfs_game(maps,x,y+1,count +1);
			maps[x][y+1] = 1;
		}
		
		if(x>0 && maps[x-1][y] != 0) {
			maps[x-1][y] = 0;
			dfs_game(maps,x-1,y,count +1);
			maps[x-1][y] = 1;
		}
		
		if(x>0 && maps[x][y-1] != 0) {
			maps[x][y-1] = 0;
			dfs_game(maps,x,y-1,count +1);
			maps[x][y-1] = 1;
		}
		
	
	}
	
	
	
	
	 public int solution_targetNumber(int[] numbers, int target) {
		 int answer = 0;
		 	dfs_targetNumber(numbers,0,target,0);
	        return answer;
	    }
	
	 public void dfs_targetNumber(int[] num,int depth,int target,int sum) {
//		�������� : depth�� num.lengh�ϰ�� (�ִ� ���� ���)
		 if(depth == num.length) {
			 if(sum == target) {
//				 answer ++;
			 }
			 return;
		 } 
//		 ���� ���� ���鼭 ���ϱ�,���� �ΰ��� ��� ���ȣ��
		 dfs_targetNumber(num,depth+1,target,sum+num[depth]);
		 dfs_targetNumber(num,depth+1,target,sum-num[depth]);
		 
	 }
	 

}
