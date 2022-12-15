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
		
		System.out.println("�ʱ� Queue1 ���");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		queue1.remove();
		
		System.out.println("Queue1 remove �� �� ���");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		queue1.add(40);
		queue1.add(queue1.remove());
		
		System.out.println("Queue1 add, add(remove) �� �� ���");
		for(int a : queue1) {
			System.out.println(a);
		}
		System.out.println();
		
		System.out.println("add(40)��� ���������� 40�̶�� ���� �߰��� �ǰ�");
		System.out.println("add(remove)�� ��� �տ��ִ� 20�̶�� ���� ������ �� ��, �ڿ� ���Ӱ� �� ���� Ȯ���� �� �ִ�.");
		System.out.println();
		
		//Queue2
		MyNode tmpNode1 = new MyNode(1, "KIM");
		queue2.add(tmpNode1);
		
		tmpNode1 = new MyNode(2, "LEE");
		queue2.add(tmpNode1);
		
		tmpNode1 = new MyNode(3, "CHOI");
		queue2.add(tmpNode1);
		
		System.out.println("Queue2 �ʱ� add ���");
		for(MyNode s : queue2) {
			System.out.println(s);
		}
		System.out.println();
		
		queue2.remove();
		
		System.out.println("Queue2 remove �� ���");
		for(MyNode s : queue2) {
			System.out.println(s);
		}
		System.out.println("��ó�� �ʱ� �� KIM�� ���� �����Ǵ� ���� �� �� �ִ�");
	}

}
