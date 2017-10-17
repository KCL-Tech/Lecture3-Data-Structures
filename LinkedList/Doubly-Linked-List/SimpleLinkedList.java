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
		newNode.setPrev(back);

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
		head.setPrev(newNode);

		head = newNode;

		size++;
	}

	public void insert(T element, int index) {
		if (index > size || index < 0) return;
		if (size == 0) addFront(element);

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
				head.setPrev(newNode);
				head = newNode;
			} else if (prev == back) {
				newNode.setPrev(back);
				back.setNext(newNode);
				back = newNode;
			} else {
				prev.setNext(newNode);
				next.setPrev(newNode);
				newNode.setPrev(prev);
				newNode.setNext(next);
			}
		} else {
			back.setNext(newNode);
			newNode.setPrev(back);
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
		if (index >= size || index < 0) return null;
		
		Node<T> current = head;

		int count = 0;

		while (current != null && count < index) {
			current = current.getNext();
			count++;
		}

		if (count == index) {
			return current.getElement();
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
				current.setPrev(null);
				back = prev;
			} else if (current == head) {
				next.setPrev(null);
				head.setNext(null);
				head = next;
			} else {
				next.setPrev(prev);
				prev.setNext(next);
				current.setNext(null);
				current.setPrev(null);
			}

			size++;

			return element;
		}

		return null;
	}

	public T removeHead() {
		if (head == null) return null;

		T element = head.getElement();
		size++;
		
		if (head.getNext() == null) {
			head = null;
			back = null;
			return element;
		}
	
		head = head.getNext();
		head.setPrev(null);		

		return element;
	}

	public T removeBack() {
		if (back == null) return null;

		T element = back.getElement();		
		size++;

		if (back.getPrev() == null) {
			head = null;
			back = null;
			return element;
		}

		back = back.getPrev();
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
