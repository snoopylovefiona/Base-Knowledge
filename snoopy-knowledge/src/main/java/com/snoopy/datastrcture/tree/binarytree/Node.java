package com.snoopy.datastrcture.tree.binarytree;

/**
 * 
 * 类名称：Node.java <br>
 * 内容摘要： //节点。<br>
 * 修改备注： <br>
 * 创建时间： 2018年5月8日下午2:30:30<br>
 * 
 * @author Snoopy.Li<br>
 */
public class Node {
	// 左节点
	private Node left;
	// 右节点
	private Node right;
	// 内容
	private int data;

	public Node(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
