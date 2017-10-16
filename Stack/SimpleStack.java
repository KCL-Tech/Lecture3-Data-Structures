import java.util.ArrayList;

public class SimpleStack <T> {
	private ArrayList<T> data;


	public SimpleStack(int size) {
		data = new ArrayList<T>(size);
	}

	public SimpleStack() {
		data = new ArrayList<T>();
	}

	public void push(T element) {
		data.add(element);
	}

	public T pop() {
		T temp = data.get(data.size() - 1);
		data.remove(temp);
		return temp;
	}

	public T top() {
		return data.get(data.size() - 1);
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		return data.size() == 0;
	}

	public void clear() {
		data.clear();
	}
}
