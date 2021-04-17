package app;

import java.util.Iterator;

class LinkedNodeIterator<T> implements Iterator<T> {
    private Node<T> next;

    public LinkedNodeIterator(Node<T> first) {
        this.next = first;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T next() {
        T result = next.getData();
        next = next.getNext();
        return result;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}