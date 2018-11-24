package myLinkedListPackage;

public class MyLinkedList {
    public int val;
    MyLinkedList next;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        MyLinkedList temp = this;
        int i = 0;
        while (index > i++) {
        	if (temp.next != null) temp = temp.next;
        	else return -1;
        }
        if (index == i-1 && temp.next != null) return temp.val;
        else return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	MyLinkedList newLinkedList = new MyLinkedList();
    	newLinkedList.next = this.next;
    	newLinkedList.val = this.val;
    	this.val = val;
    	this.next = newLinkedList;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	MyLinkedList temp = this;
    	while (temp.next != null) {
    		temp = temp.next;
    	}
    	temp.val = val;
    	temp.next = new MyLinkedList();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        MyLinkedList temp = this;
        int i =0;
        while (index > i++) {
        	if (temp.next == null)
        		return;
        	temp = temp.next;
        }
        if (index == i-1) {
        	MyLinkedList newLinkedList = new MyLinkedList();
        	newLinkedList.val = temp.val;
        	newLinkedList.next = temp.next;
        	temp.val = val;
        	temp.next = newLinkedList;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        MyLinkedList temp = this;
        int i = 0;
        while ( index > i++ && temp.next != null ){
            temp = temp.next;
        }
        if (index == i-1 && temp.next != null){
            temp.val = temp.next.val;
            temp.next = temp.next.next;
        }
    }
}
