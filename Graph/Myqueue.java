import java.util.LinkedList;
import java.util.Queue;

class MyNode {
	int id;
	String name;
	public MyNode(int id1, String name1) {
		id=id1;
		name=name1;
	}
	public String toString() {
		return "id="+id+" name="+name;
	}
}

public class Myqueue {

	public static void main(String[] args) {
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<MyNode> queue2 = new LinkedList<>();
		
		//Queue1
		queue1.add(10);
		queue1.add(20);
		queue1.add(30);
		
		System.out.println("초기 Queue1 결과");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		queue1.remove();
		
		System.out.println("Queue1 remove 한 후 결과");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		queue1.add(40);
		queue1.add(queue1.remove());
		
		System.out.println("Queue1 add, add(remove) 한 후 결과");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		System.out.println("add(40)결과 정상적으로 40이라는 값이 추가가 되고");
		System.out.println("add(remove)의 결과 앞에있던 20이라는 값이 삭제가 된 후, 뒤에 새롭게 들어간 것을 확인할 수 있다.");
		System.out.println();
		
		//Queue2
		MyNode tmpNode1 = new MyNode(1, "KIM");
		queue2.add(tmpNode1);
		
		tmpNode1 = new MyNode(2, "LEE");
		queue2.add(tmpNode1);
		
		tmpNode1 = new MyNode(3, "CHOI");
		queue2.add(tmpNode1);
		
		System.out.println("Queue2 초기 add 결과");
		for(MyNode s : queue2) {
			System.out.println(s);
		}
		System.out.println();
		
		queue2.remove();
		
		System.out.println("Queue2 remove 후 결과");
		for(MyNode s : queue2) {
			System.out.println(s);
		}
		System.out.println("위처럼 초기 값 KIM이 먼저 삭제되는 것을 볼 수 있다");
	}

}
