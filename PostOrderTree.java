import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTree {
	ArrayList<Integer> result1 = new ArrayList<>();
	ArrayList<Integer> result2 = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();

	public ArrayList<Integer> postOrderRecursion(TreeNode root) {
		if (root != null) {
			postOrderRecursion(root.left);
			postOrderRecursion(root.right);
			result2.add(root.data);
		}
		return result2;
	}

	public ArrayList<Integer> postOrderTraversal(TreeNode root) {
		TreeNode curr = root;
		if (curr == null) {
			return result1;
		}
		s.push(curr);
		TreeNode prev = null;
		while (!s.isEmpty()) {
			curr = s.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					s.push(curr.left);
				} else if (curr.right != null) {
					s.push(curr.right);
				} else {
					s.pop();
					result1.add(curr.data);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					s.push(curr.right);
				} else {
					s.pop();
					result1.add(curr.data);
				}
			} else {
				if (curr.right == prev) {
					s.pop();
					result1.add(curr.data);
				}
			}
			prev = curr;
		}
		return result1;
		
	}
}
