package com.modunle2.advanced.dsa.queue;
import java.util.LinkedList;
public class QueueLinkedList<E> {
    private LinkedList<E> queue;

    public QueueLinkedList() {
        queue = new LinkedList<>();
    }

    public void enqueue(E element){
        queue.addLast(element);
    }

    public E dequeue(){
        if(queue.isEmpty()){
            return (E) "Queue is empty";
        }
        return (E) queue.get(0);
    }

    public E peek(){
        if(queue.isEmpty()) {
            return null;
        }
        return (E) queue.get(0);
    }

    public void display(){
        System.out.print("\nQueue : \n");
        if (queue.isEmpty())
        {
            System.out.print("Empty\n");
            return ;
        }
        for(E o : queue)
            System.out.print(o + "\n");
    }



    public static void main(String[] args) {
        QueueLinkedList<String> queueLinkedList = new QueueLinkedList<>();
        queueLinkedList.enqueue("Quang Teo");
        queueLinkedList.enqueue("That");
        queueLinkedList.enqueue("Xinh");

        queueLinkedList.display();
        System.out.println("*******************************");
        System.out.println(queueLinkedList.dequeue());
        System.out.println("*******************************");
        System.out.println(queueLinkedList.peek());
        System.out.println("*******************************");
        queueLinkedList.display();

    }
}
