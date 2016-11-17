import java.util.ArrayList;

public class Realisation {

    static void output(InterfaceList list) {
        if(list.getClass() == MyArrayList.class){
            System.out.print("Array list: ");
        } else System.out.print("Linked list: ");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    static void contain(InterfaceList list, Integer i) {
        if (list.contain(i)) {
            System.out.println("list contains " + i);
        } else {
            System.out.println("list doesn't contain " + i);
        }
    }

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            linkedList.add(i);
        }

        output(list);

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
    }

}
