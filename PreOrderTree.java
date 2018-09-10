import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTree {
	ArrayList<Integer> result = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();

	public ArrayList<Integer> preOrderTraversal(TreeNode root) {
		if (root == null) {
			return result;
		}
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode tmp = s.pop();
			result.add(tmp.data);
			if (tmp.right != null) {
				s.push(tmp.right);
			}
			if (tmp.left != null) {
				s.push(tmp.left);
			}
		}
		return result;
	}

	ArrayList<Integer> result2 = new ArrayList<>();

	public ArrayList<Integer> preOrderRecursion(TreeNode root) {

		if (root != null) {
			result2.add(root.data);
			preOrderRecursion(root.left);
			
			preOrderRecursion(root.right);
		}
		return result2;
	}
}
