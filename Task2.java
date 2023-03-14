package HW4;

import java.util.Arrays;
import java.util.LinkedList;

//Реализуйте очередь с помощью LinkedList со следующими методами:
//enqueue() - помещает элемент в конец очереди,
//dequeue() - возвращает первый элемент из очереди и удаляет его,
//first() - возвращает первый элемент из очереди, не удаляя.
public class Task2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(list);
        enqueue(list, 1234);
        System.out.println(list);
        System.out.println((dequeue(list)));
        System.out.println(first(list));
    }
    public static LinkedList enqueue(LinkedList list, Object obj){
        list.addLast(obj);
        return list;
    }
    public static Object dequeue(LinkedList list){
        Object obj = list.getFirst();
        list.removeFirst();
        return obj;
    }
    public static Object first(LinkedList list){
        return list.getFirst();
    }
}
