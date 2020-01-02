public class LinkedListDeque<T> {
    private Node<T> head;
    private int size = 0;

    public LinkedListDeque(){
        head = new Node<>(null, null, null);
        head.setPrev(head);
        head.setNext(head);
    }

//    public LinkedListDeque(LinkedListDeque other) {
//        head = new Node<>(null, null, null);
//            head.setPrev(head);
//            head.setNext(head);
//        for (int i = 0; i < other.size(); i++) {
//            addLast((T) other.get(i));
//        }
//    }

    public void addFirst(T data) {
        Node<T> front = new Node<>(head, data, head.getNext());
        head.getNext().setPrev(front);
        head.setNext(front);
        size++;
    }

    public void addLast(T data) {
        Node<T> last = new Node<>(head.getPrev(), data, head);
        head.getPrev().setNext(last);
        head.setPrev(last);
        size++;
    }

    public boolean isEmpty() {
        return head.getNext() == head;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> temp = head.getNext();
        while (temp != head) {
            System.out.print(temp.getElement() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> first = head.getNext();
        head.setNext(first.getNext());
        head.getNext().setPrev(head);
        first.setPrev(null);
        first.setNext(null);
        size--;
        return first.getElement();
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node<T> last = head.getPrev();
        head.setPrev(last.getPrev());
        head.getPrev().setNext(head);
        last.setPrev(null);
        last.setNext(null);
        size--;
        return last.getElement();
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int counter;
        Node<T> temp;
        if (index < size / 2) {
            counter = 0;
            temp = head.getNext();
            while (counter < index) {
                temp = temp.getNext();
                counter++;
            }
        } else {
            counter = size - 1;
            temp = head.getPrev();
            while (counter > index) {
                temp = temp.getPrev();
                counter--;
            }
        }
        return temp.getElement();
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        if (index < size / 2) {
            return getRecursiveFirstHalf(head.getNext(), index);
        } else {
            return getRecursiveSecondHalf(head.getPrev(), size - 1 - index);
        }
    }

    private T getRecursiveFirstHalf(Node<T> temp, int index) {
        if (index == 0) {
            return temp.getElement();
        }
        return getRecursiveFirstHalf(temp.getNext(), index - 1);
    }

    private T getRecursiveSecondHalf(Node<T> temp, int index) {
        if (index == 0) {
            return temp.getElement();
        }
        return getRecursiveSecondHalf(temp.getPrev(), index - 1);
    }

}
