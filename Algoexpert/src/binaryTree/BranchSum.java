package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BranchSum {

	static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		BinaryTree(int x) {
			value = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + value + "]";
		}
	}

	static List<Integer> l = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree root = new BinaryTree(10);
		List<Integer> result = new ArrayList<Integer>();
		helper(result, root, 0);

		System.out.println(result);

	}

	public static void helper(List<Integer> result, BinaryTree root, int sum) {
		if(root== null)
			return;
		
		if (root.left == null && root.right == null) {
			sum += root.value;
			result.add(sum);
			return;
		}
		
		int midSum= sum+ root.value;
		helper(result, root.left, midSum);
		helper(result, root.right, midSum);
	}

}
