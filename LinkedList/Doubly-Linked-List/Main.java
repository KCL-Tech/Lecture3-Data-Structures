import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			linkedList.addBack(i);
		}

		System.out.println(linkedList.remove(5));

		System.out.println(linkedList);


		linkedList.insert(10, 0);
		System.out.println(linkedList);
		linkedList.insert(10, linkedList.size());
		System.out.println(linkedList);

		while (!linkedList.empty()) {
			System.out.println(linkedList.removeBack());
		}

	}
}
