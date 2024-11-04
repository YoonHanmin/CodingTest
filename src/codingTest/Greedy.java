package codingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    System.out.println(solution_sugar(N));
	
	}
	
	public static int solution_sugar(int n) {
		int answer = 0;
	
				while(true) {
					if(n%5==0) {
						answer += n/5;
						break;
					}else {
						n -= 3;
						answer ++;
					}
					if(n<0) {
						answer = -1;
						break;
					}
				
				}
			
		
		
		return answer;
		
	}
	
	
	
	public int solution_JoyStick(String name) {
        int answer = 0;
        
        char[] arr = new char[27];
        for(int i =0;i<26;i++) {
        	arr[i] = (char) (65+i);
        }
        arr[26] = 'A';
        
        int count=0;
        char c = name.charAt(0);
        for (int i = 26; i >0 ;i--) {
			if(arr[i] != c) {
				count ++;
			}else {
				break;
			}
		}
        
        for(char a : arr) {
        	System.out.print(a+",");
        }
        
        
        
        
        return answer;
    }
	
	 public int solution_Ã¼À°º¹(int n, int[] lost, int[] reserve) {
	        int lostNum = lost.length;
		        int answer = n-lostNum;
		        Arrays.sort(lost);
		        Arrays.sort(reserve);
		       
		        for (int i = 0; i < lost.length; i++) {
					for (int j = 0; j < reserve.length; j++) {
						if(lost[i]==reserve[j]) {
							lost[i] = -1;
							reserve[j] = -1;
							answer++;
							break;
						}
						
					}
				}
		      
		        for (int i = 0; i < lost.length; i++) {
					for (int j = 0; j < reserve.length; j++) {
						if(lost[i] == -1 || reserve[j]== -1) {
							continue;
						}
						
						if(lost[i]-1==reserve[j] || lost[i]+1==reserve[j]) {
							lost[i] = -1;
							reserve[j] = -1;
							answer++;
							break;
						}
						
					}
				}
		      	        return answer;
	    }
}
