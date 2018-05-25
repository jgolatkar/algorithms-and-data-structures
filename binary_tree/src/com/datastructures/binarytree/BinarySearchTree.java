package com.datastructures.binarytree;

/**
 * @author jitesh
 *
 */

public class BinarySearchTree {

	private TreeNode root;

	public void insert(Integer data) {
		if (this.root != null) {
			this.root.insert(data);
		} else {
			this.root = new TreeNode(data);
		}
	}

	public TreeNode find(Integer data) {

		if (this.root != null) {
			return this.root.find(data);
		}

		return null;
	}

	public void delete(Integer data) {
		TreeNode toDel = this.find(data);
		if (toDel != null) {
			toDel.setDeleted(true);
		}
	}

	public void traverseInOrder() {
		System.out.print("[ ");
		if (this.root != null) {
			this.root.traverseInOrder();
		}
		System.out.print("]\n");
	}

	public Integer largest() {
		if (this.root != null) {
			return this.root.largest();
		}

		return null;
	}

	public Integer smallest() {
		if (this.root != null) {
			return this.root.smallest();
		}

		return null;
	}

}
