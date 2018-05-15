package pl.coderstrust.my_linked_list;


import java.util.Iterator;

public class MyLinkedList implements Iterable {
    private Node<Object> head;
    private Node<Object> tail;

    void add(Object toBeAdded) {
        Node<Object> newNode = new Node();
        newNode.setValue(toBeAdded);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextRef(newNode);
            tail = newNode;
        }
    }

    boolean remove(Object toBeRemoved) {
        Node<Object> nodeBeforeDelete = head;
        boolean removed = false;

        if (nodeBeforeDelete != null) {
            if (nodeBeforeDelete.getValue() == toBeRemoved) {
                head = head.nextRef;
                removed = true;
            } else {
                Node next;
                do {
                    next = nodeBeforeDelete.getNextRef();
                    if (next.getValue() == toBeRemoved) {
                        removed = true;
                    } else {
                        nodeBeforeDelete = next;
                    }
                } while (next != null && !removed);
                next = nodeBeforeDelete.nextRef;
                nodeBeforeDelete.setNextRef(next.getNextRef());
                next.setNextRef(null);
            }
        }
        return removed;
    }

    boolean contains(Object required) {
        Node<Object> checkedNode = head;
        while (checkedNode != null) {
            if (checkedNode.compareTo(required) == 0) {
                return true;
            }
            checkedNode = checkedNode.getNextRef();
        }
        return false;
    }

    class Node<T> implements Comparable<T> {

        private T value;
        private Node<T> nextRef;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNextRef() {
            return nextRef;
        }

        public void setNextRef(Node<T> nextRef) {
            this.nextRef = nextRef;
        }

        @Override
        public int compareTo(T toCompare) {
            if (toCompare == this.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedList.MyIterator();
    }

    private class MyIterator implements Iterator {
        MyLinkedList.Node<Object> currentNode;
        MyLinkedList.Node<Object> previousNode;
        boolean canRemove = false;

        @Override
        public boolean hasNext() {
            if (currentNode == null) {
                return (MyLinkedList.this.head != null);
            }
            return (currentNode.getNextRef() != null);
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                return null;
            }
            if (currentNode == null) {
                currentNode = head;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNextRef();
            }
            canRemove = true;
            return currentNode.getValue();
        }

        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException();
            }
            if (currentNode != null) {
                if (previousNode != null) {
                    previousNode.setNextRef(currentNode.getNextRef());
                } else {
                    MyLinkedList.this.head = currentNode.getNextRef();
                }
            }
            canRemove = false;
        }
    }
}