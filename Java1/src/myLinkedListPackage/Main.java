package myLinkedListPackage;

public class Main {
	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		
		obj.addAtHead(0);
		obj.addAtHead(1);
		obj.addAtHead(2);
		obj.addAtIndex(3, 3);
		obj.deleteAtIndex(2);
		obj.addAtTail(4);
		for (int i = 0; i < 4; i++)
			System.out.println(obj.get(i));
	}
}
