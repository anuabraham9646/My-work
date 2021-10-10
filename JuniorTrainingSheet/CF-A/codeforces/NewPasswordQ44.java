package codeforces;

public class NewPasswordQ44 {

	//https://codeforces.com/contest/770/problem/A
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(helper(26,26));

	}

	private static String helper(int n, int k) {
		StringBuilder s= new StringBuilder();
  	    while(n>0){
  	        char c= (char) ('a' + n%k);
  	        //System.out.println(c +" "+n +" "+k);
  	        s.append(c);
  	        n--;
  	    }
  	    return s.toString();
	}

}
