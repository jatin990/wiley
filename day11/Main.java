package wiley.programs.day11;

public class Main {

	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);

		 s.pop();
//		 s.pop();
//		 s.pop();

		 System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
	}

}

class Stack {
	private int CAPACITY;
	private int filled = 0;
	private int s[];

	Stack(int size) {
		this.CAPACITY = size+1;
		this.s = new int[this.CAPACITY+1];
	}

	public void push(int x) {
		if (filled < CAPACITY-1) {
			s[++filled] = x;

		}else {
			System.out.println("Stack overflow");
		}
	}

	public int pop() {
		if(filled==0) {
			System.out.println("Stack empty");
			//throw exception here
			return -1;
		}
		int ret = s[filled];
		s[filled--] = 0;
		return ret;

	}

	public int peek() {
		if(filled==0) {
			System.out.println("Stack empty");
			//throw exception here
			return -1;
		}
		return s[filled];
	}

}