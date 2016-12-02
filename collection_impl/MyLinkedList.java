package collection_impl;

import collection.IList;
import Iterator.Iterable;
import Iterator.Iterator;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements IList<T>, Iterable<T> {
    private Node first; //first
    private Node last; //last
    private int size = 0; // position
    private int index;

    @Override
    public void add(T T) {
        System.out.println("Adding node " + T + " at the end");
        Node<T> node = new Node<T>(T);
        if (size == 0) {
            first = node;
            last = node;
            node.index = 0;
            index = 0;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
            node.index = size();
        }
        size++;

    }

    @Override
    public void remove(int index) {
        Node temp = first;

        while (temp != null) {
            if (size == 0) {
                System.out.println("This list is empty");
            } else if (temp.index == index) {
                System.out.println("Deleting node on " + index + " position");
                if (temp.next.next != null && temp.prev.prev != null) {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                    reindex(temp.prev.index, temp.prev);
                    size--;
                    break;
                }
            } else temp = temp.next;
        }
    }

    @Override
    public T get(int position) {
        Node temp = first;
        while (temp != null) {
            if (temp.index == position) {
                break;
            } else temp = temp.next;
        }
        return (T) temp.element;
    }

    @Override
    public boolean contain(T T) {
        Node temp = first;
        boolean isContain = false;
        while (temp != null) {
            if (temp.element == T) {
                isContain = true;
                break;
            } else
                temp = temp.next;
            isContain = false;
            break;
        }
        return isContain;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    public void addFirst(T T) {
        System.out.println("Adding node " + T + " at the start");
        Node node = new Node(T);

        if (size == 0) {
            first = node;
            last = node;
            index = 0;
        } else {
            node.next = first;
            first.prev = node;
            first = node;
            reindex(0, first);
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("The list is empty");
        } else {
            System.out.println("Deleting node " + first.element + " from start");
            first = first.next;
            first.prev = null;
            reindex(0, first);
            size--;
        }
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("This is list is empty");
        } else if (size == 1) {
            removeFirst();
        } else {
            System.out.println("Deleting node " + last.element + " from end");
            last = last.prev;
            last.next = null;
            size--;
        }
    }

    public void getIndexes() {
        System.out.print("Node Indexes: \n");
        Node node = first;
        while (node != null) {
            System.out.println("node: " + node.element + " index: " + node.index);
            node = node.next;
        }
    }

    private void reindex(int index, Node node) {
        this.index = index;
        Node temp = node;
        while (temp != null) {
            temp.index = index++;
            temp = temp.next;
        }
    }

    private class Node<T> {
        T element;
        Node next;
        Node prev;
        int index;

        Node(T element) {
            this.element = element;
        }
    }

    private class ListIterator implements Iterator {
        Node<T> current = first;
        Node<T> lastReturned;
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if(!hasNext())
                throw new NoSuchElementException();
            lastReturned = current;
            current = current.next;
            currentIndex++;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if(!hasNext())
                throw new IllegalStateException();
            current = null;
            size--;
        }
    }
}
