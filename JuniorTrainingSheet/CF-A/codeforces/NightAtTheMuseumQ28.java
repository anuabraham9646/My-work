package codeforces;

public class NightAtTheMuseumQ28 {
//https://codeforces.com/contest/731/problem/A
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "aucnwhfixuruefkypvrvnvznwtjgwlghoqtisbkhuwxmgzuljvqhmnwzisnsgjhivnjmbknptxatdkelhzkhsuxzrmlcpeoyukiy";
		System.out.println(helper(s));

	}

	private static int helper(String s) {
		String input= s;
		
		int dist=0;
        int cur=0;
        int pre=1;
        //pre is initially 1 because the marker starts at 1
        int curDist=0;
        for(int i=0;i< input.length();i++){
            cur= input.charAt(i)-97+1;
            // cur is the current character we added 1 because we want to make it 1- 26 
            //pre= i==0? 1 :input.charAt(i-1)-97+1;
            curDist= Math.abs(cur-pre);
            // we take absolute because z e =  5 - 26  can go to negative value
            if(curDist > 13 ){
            	/*
            	 * total alphabet is 26 and middle is 13 if diff is between 1 to 13 then we add its 
            	 * or traverse is clockwise
            	 * but suppose a z diff is 25 instead of clockwise we can go anticlockwise and distance we can minus from 26
            	 */
                dist+= 26-curDist;
            }
            else{
                dist+=curDist;
            }
            pre=cur;
            // the current becomes previous for next character
        }
		return dist;
	}

}
