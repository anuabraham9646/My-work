package codeforces;

import java.util.Arrays;

public class ShaassAndOskolsQ36 {

	//https://codeforces.com/contest/294/problem/A
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []birds= new int[] {10,10,10,10,10};
		int [][] shots= new int[][] {{2,5},{3,13},{2,12},{1,13},{4,6}};
		
		Arrays.stream(helper(birds,shots)).forEach(System.out::println);

	}

	private static int[] helper(int[] birds, int[][] shots) {
		// TODO Auto-generated method stub
		return null;
	}

}
