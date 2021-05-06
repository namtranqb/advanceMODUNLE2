package com.modunle2.advanced.dsa.queue;

import com.modunle2.advanced.dsa.linkedlist.MyLinkedList;

public class QueueMyLinkedList1<E> {

    private MyLinkedList<E> queue;

    public QueueMyLinkedList1() {

    }

    public void enqueue(E element){
        queue.addLast(element);
    }

    public E dequeue(){
        if(queue.isEmpty()){
            return (E) "Queue is empty";
        }
        return (E) queue.getData(0);
    }

    public E peek(){
        if(queue.isEmpty()) {
            return null;
        }
        return (E) queue.getData(0);
    }

    public void display(){
//        System.out.print("\nQueue = ");
//        if (queue.isEmpty())
//        {
//            System.out.print("Empty\n");
//            return ;
//        }
//        for(int i = 0; i < queue.getSize();i++)
//            System.out.print(queue.getData(i) + "\t");

        queue.display();
    }



    public static void main(String[] args) {
        QueueMyLinkedList<String> myQueue = new QueueMyLinkedList<>();
        myQueue.enqueue("Quang Teo");
        myQueue.enqueue("That");
        myQueue.enqueue("Xinh");

        myQueue.display();
        System.out.println("*******************************");
        System.out.println(myQueue.dequeue());
        System.out.println("*******************************");
        System.out.println(myQueue.peek());
        System.out.println("*******************************");
        myQueue.display();

    }
}
