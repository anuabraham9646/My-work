package recursion;

import java.util.ArrayList;
import java.util.List;
// Q 			https://leetcode.com/problems/combination-sum/
public class Leetcode_Q39_CombinationSum {

	public static void main(String[] args) {

		int candidates[] = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> ans = combinationSum(candidates, target);

		for (List<Integer> l : ans) {
			for (int i : l) {
				System.out.print(" " + i);
			}
			System.out.println("");

		}
	}

	public static List<List<Integer>> combinationSum(int[] c, int t) {

		List<List<Integer>> ans = new ArrayList<>();
		findCombination(0, c, t, ans, new ArrayList<>());
		return ans;

	}

	public static void findCombination(int start, int[] cand, int target, List<List<Integer>> ans, List<Integer> temp) {

		if (start == cand.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(temp));
			}
			return;
		}
		if (cand[start] <= target) {
			temp.add(cand[start]);
			findCombination(start, cand, target - cand[start], ans, temp);
			temp.remove(temp.size() - 1);
			findCombination(start + 1, cand, target, ans, temp);

		} else
			findCombination(start + 1, cand, target, ans, temp);
	}

}
