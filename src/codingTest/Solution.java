package codingTest;


import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.print.attribute.HashPrintServiceAttributeSet;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		String[] arr = solution_secretMap(6,arr1,arr2);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		 }
		
	
	public static String[] solution_secretMap(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] a1 = new String[n];
        String[] a2 = new String[n];
        String zero1 = "";
        String zero2 = "";
        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {
        	
        	if(Integer.toBinaryString(arr1[i]).length()<n) {
        		diff = n-Integer.toBinaryString(arr1[i]).length(); 
        		for (int j = 0; j < diff; j++) {
        			zero1 += "0";
        		}
        		diff = 0;
        	}
        	if(Integer.toBinaryString(arr2[i]).length()<n) {
        		diff = n-Integer.toBinaryString(arr2[i]).length(); 
        		for (int j = 0; j < diff; j++) {
        			zero2 += "0";
        		}
        		diff = 0;
        	}
        	
			a1[i] = zero1+Integer.toBinaryString(arr1[i]);
			a2[i] = zero2+Integer.toBinaryString(arr2[i]);
			zero1 = "";
			zero2 = "";
		}
       
       String str ="";
        for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < n; j++) {
				if((a1[i].charAt(j)+"").equals("0") && (a2[i].charAt(j)+"").equals("0")) {
					str += " ";
				}
				
				if((a1[i].charAt(j)+"").equals("1") || (a2[i].charAt(j)+"").equals("1")) {
					str += "#";
				}
				
				
			}
			answer[i] = str;
			str = "";
		}
    
        return answer;
    }
	
	
	public static int solution_dart(String dartResult) {
        int answer = 0;
        
        int[] score = new int[3];
        int idx= 0;
        String temp = "";
        for (int i = 0; i < dartResult.length(); i++) {
			
        	switch (dartResult.charAt(i)) {
			case 'S':
				score[idx] = (int)Math.pow(Integer.parseInt(temp),1);
				temp = "";
				idx ++;
				break;
			case 'D' :
				score[idx] = (int)Math.pow(Integer.parseInt(temp), 2);
				idx ++;
				temp = "";
				break;
			case 'T' :
				score[idx] = (int)Math.pow(Integer.parseInt(temp), 3);
				idx ++;
				temp = "";
				break;
			case '*' :
				score[idx-1] *=2;
				if(idx>1) {
					score[idx-2] *=2;
				}
					break;
				
			case '#' :
					score[idx-1] *= -1;
					
					break;
			default:
				temp += dartResult.charAt(i)+"";
				break;
			}
        	
        	
        	
		}
        answer = score[0]+score[1]+score[2];
        
        return answer;
    }
	
	
	 public static int[] solution_fail(int N, int[] stages) {
	        int[] answer = {};
	        
	       
	        HashMap<Integer,Double> map = new HashMap<>();
	        
	        for(int i=1;i<=N;i++) {
	        	int user_All = 0;
	        	int user_fail = 0;
	        	for (int j = 0; j < stages.length; j++) {
					if(stages[j]>=i) {
						user_All ++;
					}
					if(stages[j]==i) {
						user_fail ++;
					}
					 if(user_All==0){
	                        map.put(i,0.0);
	                    }else{
						map.put(i, (double) user_fail/user_All);
	                    }
					
				}
	        	
	        }
	        List<Integer> list = new ArrayList<>(map.keySet());
	        // 실패율을 기준으로 내림차순 정렬
	        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

	        // 리스트를 배열로 변환하여 반환
	        return list.stream().mapToInt(i -> i).toArray();
	
			}
	    
	
	public static int solution_inhyeong(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < moves.length; i++) {
        	int position = moves[i]-1;
        	num = 0;
        	for(int j=0;j<board.length;j++) {
        		if(board[j][position]!=0) { // 인형을 집었음
        			
        			if(stack.isEmpty()) {
        			stack.push(board[j][position]);
        			System.out.println("push! "+board[j][position]);
        			board[j][position] = 0;
        			break;
        			}else {
        				num = stack.peek();
        				if(num==board[j][position]) {
        					stack.pop();
        					System.out.println("pop!  "+board[j][position]);
        					board[j][position] = 0;
        					answer +=2;
        					break;
        				}else {
        					stack.push(board[j][position]);
                			System.out.println("push! -"+board[j][position]);
                			board[j][position] = 0;
                			break;
        				}
        			}
        		}
        		}
        		
        	
        	
		}
        System.out.println(stack);
        return answer;
    }
	
	
	
	public static String solution_keypad(int[] numbers, String hand) {
        String answer = "";
        String position_L = "*";
        String position_R = "#";
        int[] number,left,right;
        
        for(int i=0;i<numbers.length;i++) {
        		
        	if(numbers[i]==1||numbers[i]==4||numbers[i]==7) {
        		answer += "L";
        		position_L = numbers[i]+"";
        	}else if(numbers[i]==3||numbers[i]==6||numbers[i]==9) {
        		answer += "R";
        		position_R = numbers[i]+"";
        	}else if(numbers[i]==2||numbers[i]==5||numbers[i]==8||numbers[i]==0) {
        		
        		
        		
        		number = findCoordinate(numbers[i]+"");
        		left = findCoordinate(position_L);
        		right = findCoordinate(position_R);
        		
        		if(calculateDistance(number, left)<calculateDistance(number, right)) {
        			answer += "L";
        			position_L = numbers[i]+"";
        		}else if(calculateDistance(number, left)==calculateDistance(number, right)){
        				if(hand.equals("right")) {
        					answer += "R";
        					position_R = numbers[i]+"";
        				}else {
        					answer += "L";
        					position_L = numbers[i]+"";
        				}
        		}else {
        			answer += "R";
        			position_R = numbers[i]+"";
        		}
        		
        	}	
        }
        
        
        return answer;
    }
//	현재좌표에서 목표 좌표까지 거리를 계산하는 메소드 
	public static int calculateDistance(int[] num,int[] position) {
		int answer = Math.abs(num[0]-position[0]) + Math.abs(num[1]-position[1]);

		return answer;
	}
	
//	특정 숫자의 죄표를 계산하는 메소드
	public static int[] findCoordinate(String str) {
		int[] answer = new int[2];
		String[][] arr = { {"1","2","3"}
		  ,{"4","5","6"}
		  ,{"7","8","9"}
		  ,{"*","0","#"}
		};
		
		for(int x=0;x<arr.length;x++) {
    		for(int y=0;y<arr[x].length;y++) {   			
    			if(str.equals(arr[x][y])) {
    				answer[0] = x;
    				answer[1] = y;
    			}
    		}
    	}
		return answer;
	}
	
	 public static String solution_newId(String new_id) {
	        String answer = "";
	        
	        new_id = new_id.toLowerCase();
	        new_id = new_id.replaceAll("[^a-z0-9._-]", "");
	        new_id = new_id.replaceAll("\\.{2,}", ".");
	        new_id = new_id.replaceAll("^\\.|\\.$","");
	        if(new_id=="") {
	        	new_id = "a";
	        }
	        
	        if(new_id.length()>16) {
	        	new_id = new_id.substring(0,15);
	        	new_id.replaceAll("\\.$", "");
	        }
	        
	        if(new_id.length()<3) {
	        	String lastChar = new_id.charAt(new_id.length()-1)+"";
	        	if(new_id.length()==1) {
	        		new_id +=lastChar;
	        		new_id +=lastChar;
	        	}else {
	        		new_id +=lastChar;
	        	}
	        }
	        
	        
	        
	        return new_id;	
	    }
	
	
	  public static int solution(String s) {
	        String answer = "";
	        String str = "";
	        HashMap<String, String> map = new HashMap<>();
	        map.put("one", "1");
	        map.put("two", "2");
	        map.put("three", "3");
	        map.put("four", "4");
	        map.put("five", "5");
	        map.put("six", "6");
	        map.put("seven", "7");
	        map.put("eight", "8");
	        map.put("nine", "9");
	        map.put("zero", "0");
	        
	        for(int i=0;i<s.length();i++){
	            
	            if(isNum(s.charAt(i)+"")){
	                answer += s.charAt(i)+"";
	            }else{
	                str += s.charAt(i)+"";
	                if(map.containsKey(str)) {
	                	answer += map.get(str);
	                	str ="";
	                }
	            }
	        }
	        
	        return Integer.parseInt(answer);
	    }
	    
	    
	    public static boolean isNum(String chr){
	        try{
	        Integer.parseInt(chr);
	            return true;
	            }catch(NumberFormatException e){
	            return false;
	        }
	    }
	    
	
	
	public static String solution_mbti(String[] survey, int[] choices) {
        String answer = "";
        String[] mbti = {"RT","CF","JM","AN"};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<4;i++) {
        	map.put(""+mbti[i].charAt(0), 0);
        	map.put(""+mbti[i].charAt(1), 0);
        }
        
        
        for(int i=0;i<survey.length;i++) {
        	int count = 0;
        	int num=0;
        	String str = survey[i];
        	
        	
        	num = 4- choices[i];
        	if(num>0) {
        		count = map.get(str.charAt(0)+"") + num;
        		map.put(str.charAt(0)+"", count);
        	}else {
        		count = map.get(str.charAt(1)+"") - num;
        		map.put(str.charAt(1)+"", count);
        	}
        }
        
        for(String key : map.keySet()) {
        	System.out.println("key :"+key+","+map.get(key));
        }
        
        
        for(int i=0;i<mbti.length;i++) {
        	String str = ""+mbti[i].charAt(0);
        	String str2 = ""+mbti[i].charAt(1);
        	
        	if(map.get(str)>map.get(str2)) {
        		answer += str;
        	}else if(map.get(str)==map.get(str2)) {
        		if((int)mbti[i].charAt(0)<(int)mbti[i].charAt(1)) {
        			answer += str;
        		}else {
        			answer += str2;
        		}
        		
        		
        	}else {
        		answer += str2;
        	}
        }
        
        return answer;
    }
	
	
	
	public static int[] solution_150370(String today, String[] terms, String[] privacies) {
        int[] answer = {};
       
        
        today = today.replace(".", "");
        HashMap<String,Integer> map = new HashMap<>();
       LinkedHashMap<Integer,String> expireMap = new LinkedHashMap<>();
      
        
        
//        terms Map구조로 할당 
        for(String str : terms) {
        	String[] term = str.split(" ");
        	map.put(term[0], Integer.parseInt(term[1]));
        }
        
        
        for(int i=0;i<privacies.length;i++) {
        	String str = privacies[i];
        	String[] term = str.split(" ");
        	String cal = term[0].replace(".", ""); 
        	
        	int year = Integer.parseInt(cal.substring(0, 4));
            int month = Integer.parseInt(cal.substring(4, 6));
            int day = Integer.parseInt(cal.substring(6, 8));
            
            if(day == 1) {
            	month = month-1;
            	day = 28;
            }else {
            	day = day-1;
            }
            
        	int num = map.get(term[1]);
        year += num/12;
        month += num%12;
        if(month> 12) {
        	year = year + (month)/12;
        	month = month%12;
        }
        	
        
        String expire = String.format("%04d%02d%02d", year,month,day);
        expireMap.put(i+1,expire);
        }
        
       ArrayList<Integer> list = new ArrayList<>();
        for (int i =0;i<expireMap.size();i++) {
            String value = expireMap.get(i+1);
            System.out.print(i+1);
            System.out.print(", value :"+expireMap.get(i+1));
            System.out.println();
         if(Integer.parseInt(today)>Integer.parseInt(expireMap.get(i+1))) {
        	 list.add(i+1);
         }
        }
       
       
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
        	answer[i] = list.get(i);
        }
		
    
     
        
        return answer;
    }
	
	 public static int solution_greedy(int n, int[] lost, int[] reserve) {
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
	
	
	 public String solution_Marathon(String[] participant, String[] completion) {
	        
		 String answer = "";
		 HashMap<String,Integer> map = new HashMap<>();
		 
		 for(String str : participant) {
			 map.put(str, map.getOrDefault(str, 0)+1);
		 }
		 
		 for(String str : completion) {
			 map.put(str,map.get(str)-1);
		 }
		 
		 for(String str : map.keySet()) {
			 if(map.get(str)!=0) {
				 answer = str;
			 }
		 }
	        return answer;
	    }
	 
	 public static int solution_Poketmon(int[] nums) {
	        int answer = 0;
	        int count = nums.length/2;
	        
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i=0;i<nums.length;i++) {
	        	map.put(nums[i], nums[i]);
	        }
	        
	        for(int a : map.keySet()) {
	        	answer++;
	        }
	        if(answer>count) {
	        	answer = count;
	        }
	        return answer;
	    }
	
	
	
	
//		K번째수
	 public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int start = commands[i][0];
			int end = commands[i][1];
			int order = commands[i][2];

			int[] arr = new int[(end - start) + 1];

			int a = 0;
			for (int l = start - 1; l < end; l++) {
				arr[a] = array[l];
				a++;
			}

			// 선택정렬
			for (int k = 0; k < arr.length - 1; k++) {
				int tmp = 0;
				for (int m = k + 1; m < arr.length; m++) {
					if (arr[k] >= arr[m]) {
						tmp = arr[k];
						arr[k] = arr[m];
						arr[m] = tmp;
					}
				}
			}

			answer[i] = arr[order - 1];

		}

		return answer;
	}
	
	public static int[] solution(int[] arr) {
		  int[] answer = {};
		  ArrayList<Integer> list = new ArrayList<>();
	
		  int num = arr[0];
		  int i = 0;
		  
		  list.add(arr[0]);
		  while(true) {
			  
			  
			  if(num!=arr[i+1]) {
				  num = arr[i+1];
				  list.add(num);
			  }else {
				  i++;
			  }
			  
			  if(i==arr.length-1) {
				  break;
			  }
		  }
		  answer = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			arr[j] = list.get(j);
		}
	        System.out.println("list >>"+answer);

	
		   

		
		return answer;
	}
	 
	 
	 public static int[] solution2(String s) {
		  int[] answer = {};
		  
		  
		  int count = s.length();
		  answer = new int[count];
		  
		  Map<Character,Integer> map = new HashMap<Character, Integer>();
		  
		  for (int i = 0; i < count; i++) {
			  
			  if(map.containsKey(s.charAt(i))) {
				  answer[i] = i- map.get(s.charAt(i));
			  }else {
				  answer[i] = -1;
			  }
			  map.put(s.charAt(i), i);
			  
		}
		  
		  for(int i = 0; i<answer.length;i++) {
		  System.out.println(answer[i]);
		  }
	        return answer;
	}
	 
	 
	public static boolean solution3(String s) {
		boolean answer = false;
		
		Stack<Character> stack = new Stack<>();
		char c = s.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c=='(') {
				stack.push(c);
			}
			if (c==')') {
				answer = false;
			}
			else {stack.pop();
			}
			if(stack.isEmpty()) {
				answer = true;
			}
		}
		
		return answer;
	}
	
	public static String solution4(String[] survey,int[] choices) {
		String answer = "";
		
		HashMap<Character,Integer> map = new HashMap<>();
		
		for (int i = 0; i < survey.length; i++) {
			int num = choices[i];
			
			if(num>4) {
			map.put(survey[i].charAt(1),map.getOrDefault(survey[i].charAt(1), 0)+num-4);
			}else {
				map.put(survey[i].charAt(0),map.getOrDefault(survey[i].charAt(0), 0)+4-num);
			}
			
		}
		
		System.out.print(map);
		return answer;
}
	
	
	  public static int[] solution5(int N, int[] stages) {
		  
	        int[] answer = {};
	        
	        int user = 0; //총 유저수
	        int failer = 0;
	        HashMap<Integer, Double> map = new HashMap<>();
	        
	        int stage = 1;
	        while(stage>=N) {
	        for (int i = 0; i < stages.length; i++) {
				if(stages[i]>=stage) {
					user++;
				}
				
				if(stages[i]<=stage) {
					failer++;
				}
			}
	        map.put(stage,(double)failer/user);
	        stage++;	
	        }
	        System.out.println(map.get(1));
	        System.out.println(map.get(2));
	        System.out.println(map.get(3));
	        System.out.println(map.get(4));
	        System.out.println(map.get(5));
	        
	        return answer;
	    }
	
	  public static int solution6(String[] friends, String[] gifts) {
		  	
		int friendCnt = friends.length;
		int[][] arr = new int[friendCnt][friendCnt];
		String str = "";
		String[] gift;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < friends.length; i++) {
			map.put(friends[i], i); // ex) 2차원배열상 friends 이름, 인덱스 값{ ryan , 0 } 
		}

		for (int i = 0; i < gifts.length; i++) {
			// {"ryan frodo"} => gift[0] = "ryan" , gift[1] = "frodo"
			// gift[0] = 준사람 , gift[1] = 받은사람을 2차원 배열 행[준사람] 열[받은사람]에 할당
			str = gifts[i]; 
			gift = str.split(" "); 
			arr[map.get(gift[0])][map.get(gift[1])] += 1;

		}

		Map<String, Integer> giftScore = new HashMap<String, Integer>();
			// 선물지수 = 2차원배열상 모든 행값(준선물 합계) - 모든 열값(받은선물 합계)
		for (int i = 0; i < arr.length; i++) {
			int snd = 0;
			int rcv = 0;

			for (int j = 0; j < arr[i].length; j++) {
				snd += arr[i][j];
				rcv += arr[j][i];
				giftScore.put(friends[i], snd - rcv);

			}

		}
		// System.out.println(giftScore);

		Map<String, Integer> answerMap = new HashMap<String, Integer>();

		for (String friend : friends) { // 결과 map 초기화
			answerMap.put(friend, 0);
		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length; j++) {
//				 System.out.println("보낸사람,받은사람 Case : " + friends[i] + " , " + friends[j]);
				if (i == j) { 
//					 System.out.println(friends[i] + " , " + friends[j] + " 통과");
					continue;
				} else {

					if (arr[i][j] > arr[j][i]) { // 보내준 사람의 선물이 더 많을 경우
//						System.out.println(">>> " + friends[i] + " 선물획득 !! 보낸사람 : " + friends[i] + ", 받은사람 :  "+ friends[j] + " 갯수: " + arr[i][j] + " , 반대 : " + arr[j][i]);

						answerMap.put(friends[i], answerMap.get(friends[i]) + 1); // 선물 추가
					} else if (arr[i][j] == arr[j][i]) { // 주고받은 선물이 같을경우

						if (giftScore.get(friends[i]) > giftScore.get(friends[j])) { // 선물지수 대소여부 비교
//							System.out.println(">>> " + friends[i] + " 선물획득 !! 보낸사람 : " + friends[i] + ", 받은사람 :  "
//									+ friends[j] + " 선물지수: " + giftScore.get(friends[i]) + " , 반대 : "
//									+ giftScore.get(friends[j]));
							answerMap.put(friends[i], answerMap.get(friends[i]) + 1);
						} else if (giftScore.get(friends[i]) == giftScore.get(friends[j])) {
//							System.out.println("아무도 선물 못받음!!");
							continue;
						}

					}

				}
			}

		}
		
//		System.out.println(answerMap);
//		결과 map 최대값 구하기
		int max = Integer.MIN_VALUE;
		for (int value : answerMap.values()) {
			if (value > max) {
				max = value;
			}
		}

		int answer = max;
		return answer;
	}
	
	  public static int[] solution(int n, int m) {
	        int[] answer = {};
	        int max = 0;
	        int min = 0;
	        answer = new int[2];
	        if(n>m) {
	        	max = n;
	        	min = m;
	        }else {
	        	max = m;
	        	min = n;
	        }
	        for (int i = 1; i <= max; i++) {
	        	if(n%i==0 && n%i==0) {
	        		answer[0] = i;
	        	}
			}
	        
	        if(m%n==0) {
	        	answer[1] = m;
	        }else {
	        	answer[1] = m*n;
	        }
	        
	        return answer;
	    }
	
	  public static int[] solution11(int[] numbers) {
	        int[] answer = {2,1,3,4,1};
	        HashSet<Integer> set = new HashSet<>();
	        for (int i = 0; i < numbers.length; i++) {
				
	        	for (int j = i+1; j < numbers.length; j++) {
	        		set.add(answer[i]+answer[j]);
					
				}
	        	
			}
	        
	        for (int a : set) {
				System.out.print(a+", ");
			}
	        
	        ArrayList<Integer> al = new ArrayList<>(set);
	        

	        Collections.sort(al);
	        int[] arr1 = new int[al.size()];
	        	    for (int i = 0 ; i < al.size() ; i++) {
	        	        arr1[i] = al.get(i).intValue();
	        	    }
	        	    answer = arr1;
	  
	        return answer;
	    }
	
	
	
	
}