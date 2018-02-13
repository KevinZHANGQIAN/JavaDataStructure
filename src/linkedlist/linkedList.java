package linkedlist;

public class linkedList {

	// ������
	static class Node {
		public Node next;
		public int value;
	}

	// ��ӡ����
	public static void printList(Node node) {
		while (node.next != null) {
			node = node.next;
			System.out.println(node.value);
		}
	}

	// ��������
	public static Node createList(int p[]) {
		Node header = new Node();
		Node node = header;
		if (p == null) {
			return header;
		}
		for (int i = 0; i < p.length; i++) {
			Node temp = new Node();
			temp.value = p[i];
			node.next = temp;
			node = temp;
		}
		return header;
	}

	// �ݹ���ת������ԭ�أ�
	public static Node reverseListRe1(Node first, Node second) {
		if (second == null) {
			return first;
		}
		Node temp = second.next;
		second.next = first;
		return reverseListRe1(second, temp);
	}

	// �ݹ���ת����ԭ�أ�
	public static Node reverseListRe2(Node header) {
		if (header == null || header.next == null) {
			return header;
		}
		Node head = reverseListRe2(header.next);
		header.next.next = header;
		header.next = null;
		return head;
	}

	// �ǵݹ���ת����
	public static Node reverseList(Node header) {
		if (header == null) {
			return header;
		}
		Node curNode = header.next;
		Node nextNode = null;
		Node head = null;
		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = head;
			head = curNode;
			curNode = nextNode;
		}
		return head;
	}

	// ��ȡ������k�����
	public static Node getLastKNode(Node header, int k) {
		if (header == null || k < 1) {
			return null;
		}
		Node behind = header;
		Node front = header.next;
		for (int i = 0; i < k; i++) {
			if (behind.next == null) {
				return null;
			}
			behind = behind.next;
		}
		while (behind.next != null) {
			front = front.next;
			behind = behind.next;
		}
		return front;
	}

	// ��ȡ�м���
	public static Node getMiddleNode(Node header) {
		if (header == null || header.next == null) {
			return null;
		}
		Node front = header.next;
		Node behind = header.next;
		while (behind != null) {
			behind = behind.next;
			if (behind != null) {
				behind = behind.next;
			} else {
				break;
			}
			front = front.next;
		}
		return front;
	}

	// ɾ�����
	public static void deleteNode(Node header, Node dNode) {
		if (header == null || dNode == null) {
			return;
		}
		if (dNode.next != null) {
			dNode.value = dNode.next.value;
			dNode.next = dNode.next.next;
		} else if (header == dNode) {
			header = null;
			return;
		} else {
			Node head = header;
			while (head.next != null && head.next.next != null) {
				head = head.next;
			}
			head.next = null;
		}
	}

	// �������
	public static void swapNode(Node header, Node nodeA, Node nodeB) {
		if (header == null || nodeA == null || nodeB == null) {
			return;
		}
		if (nodeA == header || nodeB == header) {
			return;
		}
		if (nodeA == nodeB) {
			return;
		}
		// �ҵ�nodeA��ǰ�����
		Node preA = header;
		while (preA.next != nodeA) {
			preA = preA.next;
		}
		// �ҵ�nodeB��ǰ�����
		Node preB = header;
		while (preB.next != nodeB) {
			preB = preB.next;
		}
		// nodeA��nodeB�ĺ�̽��
		Node postA = nodeA.next;
		Node postB = nodeB.next;
		// nodeA��nodeB�ĺ�̽��
		if (preB == nodeA) {
			nodeA.next = postB;
			nodeB.next = nodeA;
			preA.next = nodeB;
			// nodeB��nodeA�ĺ�̽��
		} else if (preA == nodeB) {
			nodeB.next = postA;
			nodeA.next = nodeB;
			preB.next = nodeA;
			// nodeA��nodeB������
		} else {
			preA.next = nodeB;
			nodeB.next = postA;
			preB.next = nodeA;
			nodeA.next = postB;
		}
	}
}
