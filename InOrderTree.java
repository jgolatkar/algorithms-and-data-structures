import java.util.ArrayList;
import java.util.Stack;

public class InOrderTree {
	ArrayList<Integer> result1 = new ArrayList<>();
	ArrayList<Integer> result2 = new ArrayList<>();
	Stack<TreeNode> s = new Stack<>();

	public ArrayList<Integer> inOrderTraversal(TreeNode root) {
		TreeNode currentNode = root;
		boolean done = false;
		while (!done) {
			if (currentNode != null) {
				s.push(currentNode);
				currentNode = currentNode.left;
			} else if (!s.isEmpty()) {
				currentNode = s.pop();
				result1.add(currentNode.data);
				currentNode = currentNode.right;
			} else {
				done = true;
			}
		}

		return result1;
	}

	public ArrayList<Integer> inOrderRecursion(TreeNode root) {
		if (root != null) {
			inOrderRecursion(root.left);
			result2.add(root.data);
			inOrderRecursion(root.right);
		}
		return result2;
	}

}
