public class SimpleLinkedList<T> {
	
	private Node<T> head;
	private Node<T> back;

	private int size;

	public void addBack(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			back = newNode;
			return;
		}

		back.setNext(newNode);

		back = newNode;

		size++;
	}

	public void addFront(T element) {
		Node<T> newNode = new Node<T>(element);

		if (head == null) {
			head = newNode;
			back = newNode;
			return;
		}

		newNode.setNext(head);

		head = newNode;

		size++;
	}

	public void insert(T element, int index) {
		if (index > size || index < 0) return;
		if (size == 0) addFront(element);
		if (index == size) addBack(element);

		Node<T> newNode = new Node<T>(element);

		Node<T> next = head;
		Node<T> prev = null;

		int count = 0;

		while (next != null && count < index) {
			prev = next;
			next = next.getNext();
			count++;
		}

		if (count == index) {
			if (next == head) {
				newNode.setNext(head);
				head = newNode;
			} else {
				prev.setNext(newNode);
				newNode.setNext(next);
			}
		} else {
			back.setNext(newNode);
			back = newNode;
		}

		size++;
	}

	public boolean empty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		Node<T> node = getNode(index);

		if (node == null) return null;
		return node.getElement();
	}

	private Node<T> getNode(int index) {
		if (index >= size || index < 0) return null;
		
		Node<T> current = head;

		int count = 0;

		while (current != null && count < index) {
			current = current.getNext();
			count++;
		}

		if (count == index) {
			return current;
		}

		return null;
	}

	public T remove(int index) {
		if (index >= size()) return null;

		Node<T> prev = null;
		Node<T> current = head;

		int count = 0;

		while(current != null && count < index) {
			prev = current;
			current = current.getNext();
			count++;
		}

		if (count == index) {
			Node<T> next = current.getNext();
			T element = current.getElement();

			if (current == back) {
				prev.setNext(null);
				back = prev;
			} else if (current == head) {
				head.setNext(null);
				head = next;
			} else {
				prev.setNext(next);
				current.setNext(null);
			}

			size--;

			return element;
		}

		return null;
	}

	public T removeHead() {
		if (head == null) return null;

		T element = head.getElement();
		size--;
		
		if (head.getNext() == null) {
			head = null;
			back = null;
			return element;
		}
	
		head = head.getNext();

		return element;
	}

	public T removeBack() {
		if (back == null) return null;

		T element = back.getElement();		
		size--;

		Node<T> prev = getNode(size - 1);

		if (prev == null) {
			head = null;
			back = null;
			return element;
		}

		back = prev;
		back.setNext(null);

		return element;
	}

	@Override
	public String toString() {
		String out = "{ ";

		if (head != null) {
			out += "[X]<->[" + head.toString() + "]<->";
			if (head.getNext() != null) {
				Node<T> current = head.getNext();

				while (current != null && current != back) {
					out += "[" + current.toString() + "]<->";

					current = current.getNext();
				}
			}
		}

		if (head != back) {
			out += "[" + back.toString() + "]<->[X]";
		} else {
			out += "[X]";
		}

		return out + " }";
	}
}
