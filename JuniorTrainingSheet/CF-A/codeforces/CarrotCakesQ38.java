package codeforces;

public class CarrotCakesQ38 {
//https://codeforces.com/contest/799/problem/A#

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(helper(8, 6, 4, 5));

	}

	/*
	 * n, t, k, d (1 ≤ n, t, k, d ≤ 1 000) — the number of cakes needed, the time
	 * needed for one oven to bake k cakes, the number of cakes baked at the same
	 * time, the time needed to build the second oven.
	 */
	private static boolean helper(int n, int t, int k, int d) {
		// TODO Auto-generated method stub

		 if(k >= n){
			 // means it can be done in the first iteration itself
	            return false;
	        }
	        int oneOvenT= ((n+k-1)/k) * t;
	        // time taken with only owen 
	        boolean whatIf= d>=(oneOvenT-t);
	        /*
	         * suppose total time to bake is 12 min and 1 bake in 4 sec
	         * so last bake will start at 8th minute
	         * if the owen is made before the 8th minute then the speed double up and we will be benefited
	         * if the owen made after 8 like 9 th min then the 1st owen will itself finish first 
	         */
	        if(whatIf)
	            System.out.println("NO");
	        else
	            System.out.println("YES");
			return whatIf;
	    }
	}


