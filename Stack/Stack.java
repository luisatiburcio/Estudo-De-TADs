package Stack;

import java.util.Iterator;

import Common.Node;
import Common.TADIterator;

public class Stack<T> implements Iterable<T> {

    Node<T> element; // Elemento do topo da pilha
    private Node<T> first;
    private Node<T> top;
    private int size;

    public Stack() {
        this.first = null;
        this.top = null;
        this.size = 0;
    }

    public Node<T> getTop() {
        return this.top;
    }

    protected Node<T> getFirst() {
        return this.first;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {

        return first == null;

    }

    public T peek() { // Retorna o elemento do topo da pilha

        if (first == null) {
            return null;
        } else {
            return this.top.getElement();
        }
    }

    public T pop() { // Remove o elemento do topo da pilha

        this.top = this.top.getBehind();
        this.top.setNext(this.top.getBehind());
        this.top.setNext(null);

        this.size--;
        return this.top.getElement();
    }

    public void push(T element) { // empilha //funciona

        Node<T> node = new Node<T>(element);

        if (isEmpty() == true) {
            this.first = node;
            this.top = node;
        } else {
            this.top.setNext(node);
            node.setBehind(this.top);
            this.top = node;
        }
        this.size++;
    }

    // ---------------------------------------

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node<T> p = first;
        while (!(p == null)) {
            sb.append(p.getElement() + " ");
            p = p.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {

        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Stack<T> stack = (Stack<T>) object;
        if (this.size != stack.getSize()) {
            return false;
        }
        Node<T> node = this.first;
        Node<T> node2 = stack.first;
        while (node != null) {
            if (!node.getElement().equals(node2.getElement())) {
                return false;
            }
            node = node.getNext();
            node2 = node2.getNext();
        }
        return true;

    }

    public Iterator<T> iterator() {
        return new TADIterator<T>(this.first);
    }

    public Stack<T> clone(Stack<T> Stack) {
        Stack<T> clone = new Stack<T>();
        Node<T> aux = this.first;
        while (aux != null) {
            clone.push(aux.getElement());
            aux = aux.getNext();
        }

        return clone;
    }

    public void copyToArray(T[] array) {
        Stack<T> stack = new Stack<T>();

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
    }

    public Object[] copyForArray() {
        Object[] array = new Object[this.size];
        Node<T> node = this.first;

        for (int i = 0; i < this.size; i++) {
            array[i] = node.getElement();
            node = node.getNext();
        }
        return array;
    }

}

// https://gist.github.com/ProgDan/902606
// https://www.youtube.com/watch?v=ZdU4wMyiTSs&list=PL4K_Dxb-7eWlgAqCXKR-_nK3INqZukcgt&index=1
// https://www.delftstack.com/pt/howto/java/generic-array-in-java/