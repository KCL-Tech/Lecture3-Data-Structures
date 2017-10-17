import java.util.ArrayList;

public class SimpleQueue <T> {
	private ArrayList<T> data;

	public SimpleQueue() {
		data = new ArrayList<T>();
	}

	public void enqueue(T element) {
		data.add(element);
	}

	public T dequeue() {
		T temp = data.get(0);
		data.remove(temp);
		return temp;
	}

	public T front() {
		return data.get(0);
	}

	public boolean empty() {
		return data.size() == 0;
	}

	public int size() {
		return data.size();
	}

	public void clear() {
		data.clear();
	}
}
