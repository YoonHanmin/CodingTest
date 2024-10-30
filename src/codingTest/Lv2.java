package codingTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Lv2 {
	
	public static void main(String[] args) {
		int[] arr = {2,1,1,1,0,0,0,0,0,0};
		solution_���(5,arr);
	}
	
	
	  public static int[] solution_���(int n,int[] info) {
		  int[] answer = {};
		  int arrows = n;
		  int idx = 0;
		  int appeach = 0;
		  int ryan = 0;
		  int[] arr = new int[10];
		 
		  return answer;
		  }
		  
		  public static int calculate(int n,boolean[] info) {
			  int score = 0;
			  for(int i=0;i<10;i++) {
				  if(info[i]) {
					  score += 10-i;
				  }
				  }
		  return score;
	  }
	
	
	
	  public static int solution_�Ҽ�ã��(String numbers) {
	        int answer = 0;
	        
	        int[] arr = new int[numbers.length()];
	        
	        for(int i=0;i<arr.length;i++) {
	        	arr[i] = Integer.parseInt(""+numbers.charAt(i));
	        }
	        
	        Set<Integer> list = new HashSet<>();
	        boolean[] visit = new boolean[arr.length];
	        
	        makeArr(arr, "", visit, list);
	        
	        for(int a : list) {
	        	if(isPrime(a)) {
	        		answer ++;
	        	}
	        }
	        
	        
	        
	        return answer;
	    }
//	  �Ҽ����� �ƴ��� �Ǻ��ϴ� �޼ҵ�
	  public static boolean isPrime(int num) {
		  if (num < 2) return false;
	        if (num == 2) return true;
	        if (num % 2 == 0) return false;
		
	        for (int i = 3; i <= Math.sqrt(num); i += 2) {
	            if (num % i == 0) return false;
	        }
			  
		 
		  
		  return true;
		  
	  }
	
	  public static String solution_����ū��(int[] numbers) {
  
	        String[] str = new String[numbers.length];
	        
	        for(int i=0;i<numbers.length;i++) {
	        	str[i] = String.valueOf(numbers[i]);
	        }
	        
	        Arrays.sort(str,(o1,o2) -> (o2+o1).compareTo(o1+o2));
	        if(str[0].equals("0")) {
	        	return "0";
	        }
	        
	        return String.join("", str);
	        
	    }
//	  ����Լ��� ���� ��Ʈ��ŷ �˰������� ������ �����ϴ� ���
	  public static void makeArr(int[] num,String current,boolean[] visit,Set<Integer> list) {
		  if(!current.isEmpty()) {
			  if(!(current.equals("0")||current.equals("1"))) {
				  
				  list.add(Integer.parseInt(current));
			  }
		  }
		  
		  for (int i = 0; i < num.length; i++) {
			  if(!visit[i]) {
				  visit[i] = true;
				  makeArr(num,current+num[i],visit,list);
				  visit[i] = false;
			  }
		}
	  }
	  
	 
	  
	  public static int solution(int[] queue1, int[] queue2) {
	        int answer = -2;
	        long sum = 0;
	        long q1 = 0;
	        long q2 = 0;
	        for(int a : queue1) {
	        	q1 += a;
	        }
	        for(int a : queue2) {
	        	q2 += a;
	        }
	        sum = q1 + q2;
	        
	        if(sum%2 !=0) {
	        	answer = -1;
	        }else {
	        
	        	long goal = sum/2;
	       Queue<Long> que1 = new LinkedList<>();
	       Queue<Long> que2 = new LinkedList<>();
	       for (int i = 0; i < queue1.length; i++) {
			que1.add((long) queue1[i]);
			que2.add((long) queue2[i]);
			
	       }
	   
	       int cnt = 0;;
	       
	       Long num;
	       
	       while(q1 != goal) {
	    	   if(cnt > (queue1.length+queue2.length)*2){
	    		  return -1;
	    	   }
	    	   
	    	   num = (long) 0;
	    	   
	    	   
	    	   if(q2>q1) {
	    		   num = que2.peek();
	    		   q1 += num;
	    		   q2 -= num;
	    		   que1.add(que2.poll());
	    	   }else if(q1>q2){
	    		   num = que1.peek();
	    		   q2 += num;
	    		   q1 -= num;
	    		   que2.add(que1.poll());
	    	   }else {
	    		   return cnt;
	    	   }
	    	   
	    	 
	    	   cnt ++;
	       }
	       
	       answer = cnt;
	        }
	        return answer;
	    }
	  
	  
	
	 public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
	        long answer = -1;
	        int box  = 0;
	        int empty = 0;
	        int cnt = 0;
	        int destination = 0;

	        for(int i = n-1;i>=0;i--) {
	        	
	        	if(deliveries[i]!= 0 || pickups[i] !=0) {
	        		
	        		while(box<deliveries[i] || empty < pickups[i] ) {
	        			cnt ++;
	        			box += cap;
	        			empty += cap;
	        			
	        		}
	        		box -= deliveries[i];
	        		empty -= pickups[i];
	        		answer += (i+1) * cnt * 2;
	        		
	        	}
	        }
	        
	        return answer;
	    }
	 
	 
	 
	    public static int[][] solution(int n) {
	    	int[][] answer = {};
	    	ArrayList<int[]> list = new ArrayList<>();
	    	hanoi(n,1,3,2,list);
	    	
	    	answer = new int[list.size()][2];
	    	
	    	for(int i=0;i<answer.length;i++) {
	    		for(int j=0;j<2;j++) {
	    			answer[i][j] = list.get(i)[j];
	    		}
	    	}
	    	
	        return answer;
	    }
	    public static void hanoi(int n,int from,int to,int aux,ArrayList<int[]> moves) {
	    	if(n==1) {
	    		moves.add(new int[]{from,to});
	    		return;
	    	}
	    	
	    	hanoi(n-1,from,aux,to,moves);
	    	moves.add(new int[] {from,to});
	    	hanoi(n-1,aux,to,from,moves);
	    	
	    	
	    	
	    }
	
	    public static int[] solution_�����˻�(String[] info, String[] query) {
	    	int[] answer = new int[query.length];
	    	HashMap<String, List<Integer>> map = new HashMap<>();
	    	String key;
	    	for(String str : info) {
	    		String[] arr = str.split(" ");
	    		String[] language = {arr[0],"-"};
	    		String[] field = {arr[1],"-"};
	    		String[] age = {arr[2],"-"};
	    		String[] food = {arr[3],"-"};
	    		int value = Integer.parseInt(arr[4]);
	    		
	    		
	    		for(String one : language) {
	    			for(String two : field) {
	    				for(String three : age) {
	    					for(String four : food) {
	    						key = one+two+three+four;
	    						
	    						
	    						if(!map.containsKey(key)) {
	    						map.put(key, new ArrayList<Integer>());
	    						map.get(key).add(value);
	    						}else {
	    							map.get(key).add(value);
	    						}
	    					}
	    				}
	    			}
	    		}
	    	}
	    		
//	    	2. value ����Ʈ ����
	    	for(List<Integer> list : map.values()) {
	    		if(list.size()>=2) {
	    			Collections.sort(list);
	    		}
	    	}
	    	
	  
	    	
//	    	3.binary search
	    	int index = 0;
	    	for(String str : query) {
	    		
	    		String target = str.replaceAll(" and ", "").trim();
	    		String[] arr = target.split(" ");
	    		String targetKey = arr[0].trim();
	    		int targetScore = Integer.parseInt(arr[1]);
	    		
	    		 if (!map.containsKey(targetKey)) {
	                 answer[index] = 0; // �ش� Ű�� ������ 0 ��ȯ
	                 index++;
	                 continue;
	             }
	    		
	    		
	    		
	    		int left = 0;
	    		int right = map.get(targetKey).size()-1; 
	    		int result = -1;
	    		while(left<=right) {
	    			int mid = (left+right)/2;
	    			if(map.get(targetKey).get(mid)<targetScore) {
	    				result = mid;
	    				left = mid+1;
	    			}else {
	    				right = mid-1;
	    			}
	    		}
	    		
	    		
	    		answer[index] = map.get(targetKey).size()-result-1;
	    		index ++;
	    	}
	    	
	    	
	    	return answer;
	}
	
	    
	    
}
	    
	    

