package Common;

import java.util.Iterator;

public class TADIterator<T> implements Iterator<T> {

    private Node<T> current;

    public TADIterator(Node<T> first) {
        this.current = first;
    }
    
    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T element = current.getElement();
        current = current.getNext();
        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
