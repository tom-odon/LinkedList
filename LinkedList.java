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
	public void insert(Item item) {
		Node oldFirst = first;      //we save a link to the current list
		first = new Node(); 		//first is class field and now holds a new node
		first.item = item;			//set our new nodes' item to the method arg
		first.next = oldFirst;		//connect our new node w/current list
		N++;		
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.insert(new Item("spain"));
		list.insert(new Item("in"));	
		list.insert(new Item("rain"));
		list.insert(new Item("the"));

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
