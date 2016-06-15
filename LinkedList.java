/*
*  Last update: 2016 06 14
*  Coding practice and review on data structures.
*  Working out of examples from Bob Sedgewick's Algorithms text & website.
*  CTCI implementations are slightly different. 
*/
public class LinkedList {
	private int N;		//size of the list
	private Node first; //head of the list

	/*
	* Sedgewick's text calls for a private nested class with a no-arg constructor. 
	* Item is placeholder for generic data.
	*/
	private class Node{
		private Item item;
		private Node next;
	}

	/*
	*  Initialize a new LinkedList.
	*/
	public LinkedList(){
		first = null;
		N = 0;
	}

	/*
	*  Insert a new node at the beginning. 
	*/
	public void insertAtStart(Item item) {
		Node oldFirst = first;      //we save a link to the current list
		first = new Node(); 		//first is class field and now holds a new node
		first.item = item;			//set our new nodes' item to the method arg
		first.next = oldFirst;		//connect our new node w/current list
		N++;		
	}

	public void removeFromStart() {
		this.first = first.next;
	}

	/*
	* Insert a new node at the end.
	*/
	public void insertAtEnd(Item item) {
		Node end = new Node();		//create a new node to add at end
		end.item = item;			//add the arg into new node's data
		Node n = this.first;		//iterate through each node starting at top
		while(n.next != null)		//until we encounter the last node with no
			n = n.next;				//'next' linked to it.
		n.next = end;				//Link the end node.
	}



	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.insertAtStart(new Item("spain"));
		list.insertAtStart(new Item("in"));	
		list.insertAtStart(new Item("rain"));
		list.insertAtStart(new Item("the"));

		System.out.println("\n Test insert at start: \n");

		for (Node x = list.first; x != null; x = x.next) {
			System.out.println(x.item);
		}

		System.out.println("\n Test remove from start: \n");

		list.removeFromStart();

		for (Node x = list.first; x != null; x = x.next) {
			System.out.println(x.item);
		}

		System.out.println("\n Test insert at end: \n");

		list.insertAtEnd(new Item("stains"));
		list.insertAtEnd(new Item("my"));
		list.insertAtEnd(new Item("brain"));

		for (Node x = list.first; x != null; x = x.next) {
			System.out.println(x.item);
		}

	}

}

class Item{
	//Attributes
	private String data;

	public Item(String string) {
		this.data = string;
	}

	public String toString(){
		return data;
	}
}
