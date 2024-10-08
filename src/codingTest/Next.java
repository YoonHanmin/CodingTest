package codingTest;

public class Next {
	public static void main(String[] args) {
		String s = "112321000771244134221599";
		
		System.out.println(function(s));
	}
	
	
	public static int function(String s) {
		int biggist = -1;
		
		for (int i = 0; i < s.length()-2; i++) {
			if(s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)) {
				biggist = Math.max(biggist, Integer.parseInt(s.substring(i, i+3)));
				}
			
		}
		
		
		return biggist;
	}
	
	
}
