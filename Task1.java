package HW4;

//Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class Task1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(reverseLinkedList(linkedList));
    }

    public static LinkedList reverseLinkedList(LinkedList list) {
        Stack stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            stack.add(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, stack.pop());
        }
        return list;
    }
}