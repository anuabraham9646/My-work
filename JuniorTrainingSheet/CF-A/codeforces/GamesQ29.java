package codeforces;

public class GamesQ29 {
//https://codeforces.com/contest/268/problem/A
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]=new int[][] {{100,42},{42,100},{5,42},{100,5}};
		System.out.println(helper(arr));

	}

	private static int helper(int[][] arr) {
		/*
		 * there are home n away for each
		 * 
		 */
		// TODO Auto-generated method stub
		int home[]= new int[101];
        int away[]= new int[101];
        int count=0;
        for(int i = 0; i  < arr.length ; i++){
            int ho= arr[i][0];
            /*
             * the first value is home 
             * so if the same home kit is used before in away team
             * we increase the count by value of that away teams having same home jersey
             * 
             * suppose team a home jersey is 10
             * around 5 away jersey was 10 
             * hence the team a will clas with all the 5 teams
             */
            if(away[ho]!=0)
                count+=away[ho];
            home[ho]++; 
               
            int aw= arr[i][1];
            if(home[aw]!=0)
                count+=home[aw];
            away[aw]++;
    
        }
        return count;
	}

}
