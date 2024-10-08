package codingTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution2 {
	
		public static void main(String[] args) {
				
			int[] answers = {1,3,2,4,2};
			solution3(answers);

		}
	
		 public static int[] solution3(int[] answers) {
			 	
			 	int[] first = {1,2,3,4,5};
			 	int[] second = {2,1,2,3,2,4,2,5};
		        int[] third = {3,3,1,1,2,2,4,4,5,5};
		        int a = 0;
		        int b = 0;
		        int c = 0;
		        for (int i = 0; i < answers.length; i++) {
		        	if(answers[i]==first[i%5]) {
		        		a++;
		        	}
		        	if(answers[i]==second[i%8]) {
		        		b++;
		        	}
		        	if(answers[i]==third[i%10]) {
		        		c++;
		        	}
				}
		        int[] arr = {a,b,c};
		        Arrays.sort(arr);
		        HashMap<Integer,Integer> map = new HashMap<>();
		        map.put(1, a);
		        map.put(2, b);
		        map.put(3, c);
		        
		        int max = Integer.MIN_VALUE;
		        for (int value : map.values()) {
		            if (value > max) {
		                max = value;
		            }
		        }

		        // 가장 큰 값을 가진 모든 키 찾기
		        ArrayList<Integer> maxKeys = new ArrayList<>();
		        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
		            if (entry.getValue() == max) {
		                maxKeys.add(entry.getKey());
		            }
		        }
		        
		        int[] answer = maxKeys.stream().mapToInt(Integer::intValue).toArray();
		        Arrays.sort(answer);
		        
		        return answer;
		       
		     
		        
		        
		    }
	
	   public static int solution(int[][] sizes) {
	       int max1 = Integer.MIN_VALUE;
	       int max2 = Integer.MIN_VALUE;
	       int v,h;
	       int answer = 0;
	       for (int i = 0; i < sizes.length; i++) {
			 v = Math.max(sizes[i][0], sizes[i][1]);
			 h = Math.min(sizes[i][0], sizes[i][1]);
			max1 = Math.max(max1, v);
			max2 = Math.max(max2, h);
		}
	       
	       answer = max1*max2;
		   
		   
	        return answer;
	    }
	   
	   public static int[] solution(int []arr) {
	        int[] answer = {};
	        
	   Stack<Integer> stack = new Stack<>();
	   
	   stack.push(arr[0]);
	   for (int i = 1; i < arr.length; i++) {
		   stack.push(arr[i]);
		   if(!stack.isEmpty() && stack.peek()==arr[i-1]) {
			  stack.pop();
		   }
	}
	   answer = new int[stack.size()];
	   int index = 0;
	   for(int a : stack) {
		   answer[index++] = a;
	   }
	   
	        return answer;
	    }
	   
	   public static int[] solution(int[] progresses, int[] speeds) {
	        int[] answer = {};
	        double days;
	        int count = 1;
	        Queue<Integer> que = new LinkedList<>();
	        ArrayList<Integer> list = new ArrayList();
	        for (int i = 0; i < progresses.length; i++) {
				days = Math.ceil((double)(100-progresses[i])/speeds[i]);
				que.add((int)days);
			}
	
	        int firstJob  = que.poll();
	        System.out.println("firstJob :"+firstJob);
	       
	        while(!que.isEmpty()) {
	        	
	        	if(firstJob>que.peek()) {
	        		count++;
	        		
	        		
	        }else {
	        	list.add(count);
	        	firstJob = que.peek();
	        	count = 1;	        	
	        }
	        	que.poll();
	        	
	        	if(que.isEmpty()) {
	        		list.add(count);
	        	}
	        }
	     
	       
	        answer = new int[list.size()];
	        int index = 0;
	        for(int a : list) {
	        	answer[index++] = a;
	        }
	        return answer;
	    }
}
