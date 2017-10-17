import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			linkedList.addBack(i);
		}

		linkedList.addFront(10);
		linkedList.addBack(10);

		while (!linkedList.empty()) {
			System.out.println(linkedList.removeBack());
		}

	}
}
