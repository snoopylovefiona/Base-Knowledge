package com.snoopy.datastrcture.tree.binarytree;

import java.util.Stack;

/**
 * 
 * 类名称：BinaryTree.java <br>
 * 内容摘要： //二叉树。<br>
 * 修改备注： <br>
 * 创建时间： 2018年5月8日上午10:25:58<br>
 * 
 * @author Snoopy.Li<br>
 */
public class BinaryTree {

	// 根节点
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * 递归构造二叉树
	 * 
	 * @param node
	 * @param data
	 */
	public void buildTree(Node node, int data) {
		if (root == null) {
			// 根节点下面没有子节点，即根节点为叶子节点
			root = new Node(data);
		} else {
			if (data < node.getData()) {
				// 比父节点小的放到左边
				if (node.getLeft() == null) {
					// 父节点为叶子节点
					node.setLeft(new Node(data));
				} else {
					// 父节点非叶子节点
					buildTree(node.getLeft(), data);
				}
			} else {
				// 比父节点大放到右边
				if (node.getRight() == null) {
					// 父节点为叶子节点
					node.setRight(new Node(data));
				} else {
					// 父节点为非叶子节点
					buildTree(node.getRight(), data);
				}
			}
		}
	}

	/**
	 * 递归 先序遍历二叉树<br>
	 * 直接访问p指向的节点，然后访问该节点的左子树，最后访问节点的右子树。
	 * 
	 * @param node
	 */
	public void preShow(Node node) {
		if (node != null) {
			System.out.print(node.getData() + "  ");
			preShow(node.getLeft());
			preShow(node.getRight());
		}
	}

	/**
	 * 非递归先序遍历二叉树
	 */
	public void preShow() {
		Stack<Node> stack = new Stack<>();
		Node node = root;
		while ((node != null) || stack.empty() != true) {
			if (node != null) {
				// 打印根节点
				System.out.print(node.getData() + "  ");
				// 将根节点压栈
				stack.push(node);
				node = node.getLeft();
			} else {
				node = stack.pop();
				node = node.getRight();
			}
		}

	}

	/**
	 * 递归 中序遍历二叉树<br>
	 * 先遍历节点的左子树，遍历完毕之后访问此节点，之后访问节点的右子树
	 * 
	 * @param node
	 */
	public void inorderShow(Node node) {
		if (node != null) {
			inorderShow(node.getLeft());
			System.out.print(node.getData() + "  ");
			inorderShow(node.getRight());
		}
	}

	/**
	 * 非递归中序遍历二叉树
	 */
	public void inorderShow() {
		Stack<Node> stack = new Stack<>();
		Node node = root;
		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.empty() == true) {
				return;
			}
			node = stack.pop();
			System.out.print(node.getData() + "  ");
			node = node.getRight();
		}
	}

	/**
	 * 递归 后序遍历二叉树<br>
	 * 先遍历节点的左子树，然后遍历节点的右子树，最后遍历该节点
	 * 
	 * @param node
	 */
	public void posShow(Node node) {
		if (node != null) {
			posShow(node.getLeft());
			posShow(node.getRight());
			System.out.print(node.getData() + "  ");
		}
	}

	/**
	 * 非递归后序遍历二叉树
	 */
	public void posShow() {
		Stack<Node> stack = new Stack<>();
		// 构造一个中间栈来存储逆后续遍历的结果
		Stack<Node> output = new Stack<Node>();
		Node node = root;
		while (node != null || stack.size() > 0) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.getRight();
			} else {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (output.size() > 0) {
			System.out.print(output.pop().getData() + "  ");
		}
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		int[] sample = { 9, 5, 10, 25, 3, 4, 6, 1, 40, 29 };
		for (int i = 0; i < sample.length; i++) {
			binaryTree.buildTree(binaryTree.getRoot(), sample[i]);
		}
		System.out.print("递归先序遍历:[  ");
		binaryTree.preShow(binaryTree.getRoot());
		System.out.println("]");
		System.out.print("非递归先序遍历:[  ");
		binaryTree.preShow();
		System.out.println("]");

		System.out.print("递归中序遍历:[  ");
		binaryTree.inorderShow(binaryTree.getRoot());
		System.out.println("]");
		System.out.print("非递归中序遍历:[  ");
		binaryTree.inorderShow();
		System.out.println("]");

		System.out.print("递归后序遍历:[  ");
		binaryTree.posShow(binaryTree.getRoot());
		System.out.println("]");
		System.out.print("非递归后序遍历:[  ");
		binaryTree.posShow();
		System.out.println("]");
	}

}
