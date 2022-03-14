
public class LinkedListRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DllNode head = new DllNode(5);
		DllNode newNode = new DllNode(5);
		
		head.next = newNode;
		newNode.prev = head;
		
		DoublyLinkedList newList = new DoublyLinkedList(head);
	}

}
