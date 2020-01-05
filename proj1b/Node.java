public class Node<T> {
    private T element;
    private Node<T> prev;
    private Node<T> next;

    public Node(Node<T> p, T e, Node<T> n) {
        this.element = e;
        this.prev = p;
        this.next = n;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<T> newPrev) {
        this.prev = newPrev;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> newNext) {
        this.next = newNext;
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T newElem) {
        this.element = newElem;
    }
}
