package List;

import java.util.Iterator;

import Common.TADIterator;

public class List<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    public List() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> get(int index) {
        Node<T> node = this.head;
        for (int i = 0; i < index; i++) {
            if (node.getNext() != null) {
                node = node.getNext();
            }
        }
        return node;
    }

    public void add(int index, T element) {
        Node<T> node = new Node<T>(element);
        if (index == 0) {
            node.setNext(this.head);
            this.head.setBehind(node);
            this.head = node;

        } else if (index == size) {
            this.last.setNext(node);
            node.setBehind(this.last);
            this.last = node;

        } else {
            Node<T> auxNode = this.head;
            for (int i = 0; i < index; i++) {
                auxNode = auxNode.getNext();
            }

            node.setNext(auxNode);
            node.setBehind(auxNode.getBehind());
            auxNode.getBehind().setNext(node);
            auxNode.setBehind(node);
        }
        this.size++;
    }

    public void add(T element) {
        Node<T> node = new Node<T>(element);
        if (head == null && last == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.setNext(node);
            node.setBehind(this.last);
            this.last = node;
        }
        size++;
    }

    public boolean remove(T object) {
        Node<T> node = this.head;
        Node<T> behind = null;

        for (int i = 0; i < getSize(); i++) {
            if (node.getElement().equals(object)) {
                behind.setNext(node.getNext());
                node = null;
                break;
            }
            behind = node;
            node = node.getNext();
        }
        this.size--;
        return true;
    }

    public void remove(int index) {

        if (index == 0) {
            this.head = this.head.getNext();
            this.head.setNext(this.head.getNext());
            this.head.setBehind(null);

        } else if (index == size) {
            this.last.setBehind(last.getBehind());
            this.last.setNext(null);
        } else {
            Node<T> node = this.head;
            Node<T> auxNode = this.head;
            for (int i = 0; i < index; i++) {
                auxNode = auxNode.getNext();
            }
            node = auxNode.getBehind();
            node.setNext(auxNode.getNext());
            node.setBehind(auxNode.getBehind());
        }
        this.size--;
    }

    // ----------------------------------------------------------------

    public List<T> clone(List<T> list) {
        List<T> clone = new List<T>();
        for (int i = 0; i < this.size; i++) {
            Node<T> node = this.head;
            clone.add(node.getElement());
            node = node.getNext();
        }

        return clone;
    }

    public Iterator<T> iterator() {
        return new TADIterator<T>(this.head);
    }

    public Object[] copyForArray() {
        Object[] array = new Object[this.size];
        Node<T> node = this.head;

        for (int i = 0; i < this.size; i++) {
            array[i] = node.getElement();
            node = node.getNext();
        }
        return array;
    }

    public List<T> copyToArray(T[] array) {
        List<T> list = new List<T>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        @SuppressWarnings("unchecked")
        final List<T> other = (List<T>) o;
        if (this.size != other.size) {
            return false;
        }
        Node<T> node = this.head;
        Node<T> auxNode = other.head;
        for (int i = 0; i < this.size; i++) {
            if (!node.getElement().equals(auxNode.getElement())) {
                return false;
            }
            node = node.getNext();
            auxNode = auxNode.getNext();
        }
        return true;

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node<T> p = head;
        while (!(p == null)) {
            sb.append(p.getElement() + " ");
            p = p.getNext();
        }

        sb.append("]");
        return sb.toString();
    }
}

// https://www.devmedia.com.br/explorando-a-classe-arraylist-no-java/24298
// https://www.youtube.com/watch?v=RW0oD2L_tSg
// https://www.youtube.com/watch?v=wRXdDK3zGZs
// https://pt.stackoverflow.com/questions/58219/%C3%89-poss%C3%ADvel-utilizar-ponteiros-em-java
// https://www.geeksforgeeks.org/java-implementing-iterator-and-iterable-interface/#:~:text=To%20implement%20an%20Iterator%2C%20we,cursor%20advances%20to%20next%20element
// https://www.tabnine.com/code/java/methods/java.util.ArrayList/equals