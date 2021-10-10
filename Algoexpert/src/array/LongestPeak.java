package array;

public class LongestPeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPeak(new int[] {1,2,3,3,4,0,10,6,5,-1,-3,2,3}));

	}
	public static int longestPeak(int[] a) {
		/*
		 * Approach 
		 * if length less than 3 its 0 cos atleast need 3 elt for peak
		 * 
		 * now go left to right and spot all peak, which is an elt greater than the 
		 * adjoining left and right elt
		 * 
		 * for each peak traverse its left and right and find the longest peak
		 * 
		 */
		int n= a.length;
		if(a.length <3)
			return 0;
		int longestPeak=0,current=0;
		
		int i=1;
		while(i < n-1) {
			if(a[i]>a[i-1] && a[i]>a[i+1]) {
				
				int left= i-2;
				while(left>=0 && a[left]<a[left+1])
					left--;
				int right= i+2;
				while(right<=n-1 && a[right]<a[right-1])
					right++;
				
				longestPeak=Math.max(longestPeak, right-left-1);
				i= right;
			}
			else
				i++;
		}
		return longestPeak;
	}

}
