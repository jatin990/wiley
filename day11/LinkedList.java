package wiley.programs.day11;

public class LinkedList {
	public node current=null,first=null,last=null;
	class node{
		private int item;
		public node next, prev;
		node(int item){
			this.item=item;
			this.next=null;
		}
	}
	public void add(int item) {
		node node=new node(item);
		if(first==null) {
			first=node;
			current=node;
		}
		else {
			current.next=node;
			node.prev=current;
			last=node;
			current=node;
		}
		
	}
	public void remove(int index) {
		node temp=first;
		for(int i=0;i<index;i++) {
			if(temp==null) {
				System.out.println("no element found");
				break;
			}
			temp=temp.next;
		}
		if(temp!=null) {
			temp.prev.next=temp.next;
			temp=null;
		}
	}
	public int get(int index) {
		node temp=first;
		for(int i=0;i<index;i++) {
			if(temp==null) {
				System.out.println("no element found");
				return -1;
			}
			temp=temp.next;
		}
		
		return temp.item;
	}
	public static void main(String[] args) {
		 LinkedList l=new LinkedList();
		 l.add(4);
		 l.add(5);
		 l.add(6);
		 l.add(7);
		 System.out.println(l.get(0));
		 System.out.println(l.get(1));
		 System.out.println(l.get(2));
		 System.out.println(l.get(3));
		 l.remove(5);
		 System.out.println(l.get(0));
		 System.out.println(l.get(1));
		 System.out.println(l.get(2));
	}

}

