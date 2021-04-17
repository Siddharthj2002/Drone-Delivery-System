package app;

import java.util.Iterator;

public class LinkedListMain {
    public static void main(String[] args) {
        ListInterface<Integer> list = new RecursiveList<Integer>();
        list.insertLast(22);
        list.insertLast(900);
        list.insertLast(143);
        list.insertLast(8);
        System.out.println("Completed Insertion");
        System.out.println(printList(list));
        list.removeFirst();
        System.out.println("Completed removeFirst");
        System.out.println(printList(list));
        list.removeLast();
        System.out.println("Completed removeLast");
        System.out.println(printList(list));
        list.removeAt(1);
        System.out.println("Completed removeAt");
        System.out.println(printList(list));
        list.remove(100); // should throw an ItemNotFoundException
        System.out.println("Completed main");
    }

    public static String printList(ListInterface<Integer> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> listIter = list.iterator();
        while (listIter.hasNext())
            sb.append(listIter.next()).append(" ");
        return sb.toString();
    }

}
