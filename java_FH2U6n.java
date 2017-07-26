public class LinkedList{
	Node head;
  
  class Node{
  	int data;
    Node next;
    
    public Node(int x){
      data = x;
    }
  }
  
  int mid(Node head){

if(head == null){
	return 0;
}

Node fast = head, slow = head;
int mid = 0;

while(slow != null && fast != null && slow.next != null && fast.next != null && fast.next.next != null){

	slow = slow.next;
	fast = fast.next.next;
	mid++;
}
    System.out.println("Mid Node : " + slow.data);
	return mid;
}

public Node reverse(Node head){
if(head == null){
	return null;
}

Node next = null, prev = null, curr = head;
while(curr != null){

	next = curr.next;
	curr.next = prev;
	prev = curr;
	curr = next;	
}
head = prev;
return head;
}

public Node reversePartially(Node head, int k){
if(head == null){
	return null;
}

Node next = null, prev = null, curr = head, temp = head;
int i = 0;
while(curr != null && i < k){

	next = curr.next;
	curr.next = prev;
	prev = curr;
	curr = next;
	i++;	
}

if(curr != null){
	temp.next = reversePartially(curr, k);
}
//head = prev;
return prev;
}
  
  public void add(int x){
  
    Node node = new Node(x);
    
    if(head == null){
    
    head = node;
      return;
    }
      
    
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    
  }
  
    temp.next = node;
}
  
  public void print(){
    
    Node temp = this.head;
    while(temp != null){
      
      System.out.print("\t" + temp.data);
      temp= temp.next;
    }
    System.out.println();
  }
  
  public static void main(String... ar){
  
    System.out.println("Main Started");
    LinkedList list = new LinkedList();
    System.out.println("List Initialized");
    list.add(1);
    System.out.println("Added");
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    
    list.print();
    
    ////list.head = list.reverse(list.head);
    
     //list.print();
    list.head = list.reversePartially(list.head, 3);
    list.print();
    //System.out.println(list.mid(list.head));
    //list.print();
  }
}