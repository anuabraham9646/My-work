package array;

import java.util.*;

public class Four4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//764-112
		List<Integer[]> res= fourNumberSum(new int[] {7,6,4,-1,1,2},16);
		for(Integer[] x :res) {
			for(Integer xx: x) {
				System.out.print(xx + " ");
			}
			System.out.println(" ");
		}

	}
	/*
	 * Just like 2 sum we first  check if the key is already present 
	 * only then we will add the key
	 */
	public static List<Integer[]> fourNumberSum(int[] a, int targetSum){
		
		List<Integer[]> res= new ArrayList<>();
		HashMap<Integer,List<Integer[]>>map= new HashMap<>();
		int n = a.length;
		if(n < 4)
			return res;
		for(int i=1;i<n-1;i++) {
			
			for(int j= i+1; j<n;j++) {
				int sum= a[i]+a[j];
				int diff= targetSum-sum;
				if(map.containsKey(diff)) {
					//Integer[] result= new Integer[] {a[i],a[j],map.get(diff).get(0),};
					for(Integer[]x : map.get(diff)) {
						Integer[] result= new Integer[] {a[i],a[j],x[0],x[1]};
						res.add(result);
					}
				}
			}
			
			for(int k= 0 ;k<i ;k++) {
				int sum=a[i]+a[k];
				map.putIfAbsent(sum, new ArrayList<>());
				Integer[]partial= new Integer[] {a[i],a[k]};
				map.get(sum).add(partial);
			}
		}
		
		return res;
	}

}
