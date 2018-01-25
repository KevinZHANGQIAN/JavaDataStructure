package binarytree;

import java.util.LinkedList;


public class BinaryTree1 {
	
	//������
	static void insertNode(Tree tree, int i) {
		if (tree == null) {
			return;
		}
		Node tNode = tree.root;
		Node pNode = null;
		Node nNode = new Node();
		nNode.value = i;
		while (tNode != null) {
			pNode = tNode;
			if (tNode.value <= i) {
				tNode = tNode.right;
			} else {
				tNode = tNode.left;
			}
		}

		if (pNode == null) {
			tree.root = nNode;
		} else if (pNode.value > i) {
			pNode.left = nNode;
		} else {
			pNode.right = nNode;
		}
		tree.size++;
	}

	//������
	static Tree createTree(int[] is) {
		Tree tree = new Tree();
		tree.size = 0;
		for (int i = 0; i < is.length; i++) {
			insertNode(tree, is[i]);
		}
		return tree;
	}

	//�������
	static void printTreeLevelOrder(Tree tree) {
		if (tree == null || tree.root == null) {
			return;
		}
		Node node = tree.root;
		LinkedList<Node> queue = new LinkedList<Node>();
		Node end = node;
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.getFirst();
			System.out.print(node.value);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			if (end == node) {
				System.out.print("\n");
				end = queue.getLast();
			} else {
				System.out.print(" ");
			}
			queue.pop();
		}
	}

	//��ӡ��n����
	static void printTreeKLevel(Tree tree, int n) {
		if (tree == null || tree.root == null) {
			return;
		}
		Node node = tree.root;
		LinkedList<Node> queue = new LinkedList<Node>();
		Node end = node;
		int count = 1;
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.getFirst();
			if (count == n) {
				System.out.print(node.value);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			if (end == node) {
				// System.out.print("\n");
				end = queue.getLast();
				count++;
			} else {
				System.out.print(" ");
			}
			queue.pop();
		}
	}

	//��ӡҶ�ӽڵ�
	static int getLeafNumber(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		return getLeafNumber(node.left) + getLeafNumber(node.right);

	}

	//��ӡ���ĸ߶�
	static int getTreeHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int left = getTreeHeight(node.left) + 1;
		int right = getTreeHeight(node.right) + 1;
		if (left > right) {
			return left;
		} else {
			return right;
		}
	}
}
