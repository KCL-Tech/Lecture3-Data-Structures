public class Node <T> {
	private T element;
	private Node<T> next;
	private Node<T> prev;

	public Node(T element) {
		this.element = element;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	public Node<T> getNext() {
		return next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return element.toString();
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (o instanceof Node) {
			Node node = (Node) o;
			try {
				return ((T) node.getElement()).equals(element);
			} catch (ClassCastException e) {}
		} else {
			try {
				return ((T) o).equals(element);
			} catch (ClassCastException e) {}
		}

		return false;
	}
}

