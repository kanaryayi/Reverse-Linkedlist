
public class ReverseLinkedList {

	static class Node{
		Node(int v){
			value = v;
		}
		Node(){	
		}
		
		int value ;
		Node next;
	}
	/***
	 * 
	 * @param root holds start of linkedlist
	 * @param next holds the node that it should replace
	 * @param previous holds the node that merge linkedlist after substitution, it is always the first element of the primitive linked list
	 * @return root 
	 */
	Node reverse(Node root,Node next,Node previous){
		
		// reached end of linkedlist
		if(next==null) {
			return root;
		}
		// hold rear part of linked list
		Node node = next.next;
		// root becomes second node in linkedlist
		next.next= root;
		// merge the head and rear part of linkedlist
		previous.next = node;
		
		
		return reverse(next, node,previous);
		
		
	}
	public static void main(String[] args) {
		ReverseLinkedList obj = new ReverseLinkedList();
		Node root = new Node(0);
		int size = 20;
		
		//add nodes
		for(int i = 1;i<size;i++) {
			Node node = new Node(i);
			node.next = root;
			root = node;
		}
		
		//################
		Node copy = root;
		while(copy!=null) {
			System.out.println(copy.value);
			copy = copy.next;
		}
		//################
		
		
		root = obj.reverse(root,root.next,root);
		
		
		//################
		while(root!=null) {
			System.out.println(root.value);
			root = root.next;
		}
		//################
	}

}
