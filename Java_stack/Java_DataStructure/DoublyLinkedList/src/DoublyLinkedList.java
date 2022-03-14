
public class DoublyLinkedList {
	DllNode head;
	public DoublyLinkedList (DllNode head) {
		this.head = head;
	}
		
	public void reversePrint() {
		DllNode curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		
		while(curr.prev != null)
			System.out.println(curr.Data);
			curr = curr.prev;
	}
	
}

