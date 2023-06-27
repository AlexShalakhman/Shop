package task.Task;

public class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if(head == null) { // linked list is empty
            head = newNode;
        } else { // linked list is not  empty
            Node<E> headNode = head;
            while (headNode.next != null) {
                headNode = headNode.next;
            }
            headNode.next = newNode;
        }
        size++;
    }

    public boolean remove(E element) {
        if(size == 0) {
            return false;
        }
        Node<E> currentNode = head;
        Node<E> prevNode = head;

        while (currentNode.next != null) {
            if(!currentNode.value.equals(element)) {
                currentNode = currentNode.next;
                prevNode = currentNode;
            } else {
                prevNode.next = currentNode.next;
                size--;
                return true;
            }
        }
        return false;
    }



    private static class Node<E> {
        private Node<E> next;
        private E value;

        public Node( E value) {
            this.next = null;
            this.value = value;
        }
    }


}
