package codingTest;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Lv2 {
	
	public static void main(String[] args) {
		int[] arr = {6,10,2};
		List<Integer> list = new ArrayList<>();
		boolean[] visit = new boolean[arr.length];
		makeArr(arr,"",visit,list);
		
		for(int a : list) {
			System.out.print(a+",");
		}
		
	}
	
	  public static String solution(int[] numbers) {
	        String answer = "";
	        List<Integer> list = new ArrayList<>();
	        boolean[] visit = new boolean[numbers.length];
	        makeArr(numbers,"",visit,list);
	        int max = -1;
	        for(int a : list) {
	        	if(a>max) {
	        		max = a;
	        	}
	        }
	        answer = max+"";
	        
	        return answer;
	    }
//	  재귀함수를 통한 백트레킹 알고리즘으로 조합을 생성하는 방식
	  public static void makeArr(int[] num,String current,boolean[] visit,List<Integer> list) {
		  if(!current.isEmpty()) {
			  list.add(Integer.parseInt(current));
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
	
	    public static int[] solution_순위검색(String[] info, String[] query) {
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
	    		
//	    	2. value 리스트 정렬
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
	                 answer[index] = 0; // 해당 키가 없으면 0 반환
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
	    
	    

