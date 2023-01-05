package Common;

public class Node<T> { // Pronta

    private T element;
    private Node<T> next;
    private Node<T> behind;

    public Node(T element) {
        this.element = element;
        this.next = null;
        this.behind = null;
    }

    public Node(T element, Node<T> next, Node<T> behind) {
        this.element = element;
        this.next = next;
        this.behind = behind;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
    
    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getBehind() {
        return behind;
    }

    public void setBehind(Node<T> behind) {
        this.behind = behind;
    }

}
