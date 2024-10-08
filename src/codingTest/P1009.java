package codingTest;

import java.util.Scanner;

public class P1009 {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int amount = sc.nextInt();
	int a,b;
	int answer;
	for(int i=0;i<amount;i++){
		answer = 1;
		a= sc.nextInt();
		b= sc.nextInt();
		
		for(int j=0;j<b;j++){
			answer = answer*a%10;
		}
		
		answer = answer==0?10:answer;
		System.out.println(answer);
		
	}
	sc.close();
	}
	
}
