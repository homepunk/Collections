package realisation;

import collection_impl.MyArrayList;
import collection_impl.MyLinkedList;
import collection.IList;
import Iterator.Iterator;

public class Realisation {

    static void output(IList list) {
        if (list.getClass() == MyArrayList.class) {
            System.out.print("Array list: ");
        } else System.out.print("Linked list: ");

        Iterator<Integer> it = list.iterator();
        if (list.size() == 0) System.out.println("Empty");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    static void contain(IList list, Integer i) {
        if (list.contain(i)) {
            System.out.println("list contains " + i);
        } else {
            System.out.println("list doesn't contain " + i);
        }
    }

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        Iterator<Integer> it = linkedList.iterator();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            linkedList.add(i);
        }

        output(list);
        output(linkedList);

        list.remove(1);
        list.remove(7);
        list.remove(0);

        output(list);

        contain(list, 3);
        contain(list, 1);
        contain(list, 7);


        System.out.println("The size of Doubly Linked List is " + linkedList.size());
        linkedList.getIndexes();

        System.out.println("Got: " + linkedList.get(3));
        System.out.println("Got: " + linkedList.get(4));

        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.remove(4);
        linkedList.remove(2);
        linkedList.add(5);
        linkedList.add(5);
        linkedList.add(5);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.addFirst(5);
        System.out.println("The size of Doubly Linked List is " + linkedList.size());
        linkedList.getIndexes();
        while (it.hasNext()) {
            it.remove();
        }
        output(linkedList);
    }

}
