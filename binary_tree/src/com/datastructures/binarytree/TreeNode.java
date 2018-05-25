package com.datastructures.binarytree;

/**
 * @author jitesh
 *
 */

public class TreeNode {

	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	private boolean isDeleted;

	public TreeNode(Integer data) {
		this.data = data;
		this.isDeleted = false;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getData() {
		return data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void insert(Integer data) {

		if (data >= this.data) {
			if (this.rightChild == null) {
				this.rightChild = new TreeNode(data);
			} else {
				this.rightChild.insert(data);
			}
		} else {
			if (this.leftChild == null) {
				this.leftChild = new TreeNode(data);
			} else {
				this.leftChild.insert(data);
			}
		}
	}

	public TreeNode find(Integer data) {
		if (this.data == data) {
			return this;
		} else if (data < this.data) {
			return this.leftChild.find(data);
		} else if (data > this.data) {
			return this.rightChild.find(data);
		} else {
			return null;
		}

	}

	public void traverseInOrder() {
		if (this.getLeftChild() != null) {
			this.getLeftChild().traverseInOrder();
		}
		if (!this.isDeleted) {
			System.out.print(this.getData() + " ");
		}
		if (this.getRightChild() != null) {
			this.getRightChild().traverseInOrder();
		}

	}

	public Integer smallest() {
		if (this.getLeftChild() == null) {
			return this.getData();
		}

		return this.getLeftChild().smallest();
	}

	public Integer largest() {
		if (this.getRightChild() == null) {
			return this.getData();
		}

		return this.getRightChild().largest();
	}

}
