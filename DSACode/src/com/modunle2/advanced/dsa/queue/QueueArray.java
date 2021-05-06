package com.modunle2.advanced.dsa.queue;

import java.util.Arrays;

public class QueueArray<E> {
    private int size = 0;
    private E[] queueArray;


    public QueueArray() {
        queueArray = (E[]) new Object[3];
    }

    private void ensureCapacity() {
        int newSize = queueArray.length * 2;
        queueArray = Arrays.copyOf(queueArray, newSize);
    }
    public int getSize(){
       return size;
    }

    public boolean isEmpty(){
        return (getSize() == 0)? true: false;

    }

    public void enqueue(E e){
        if(getSize() == queueArray.length ){
            ensureCapacity();
        }
        queueArray[size] = e;
        size ++;
    }

    public void dequeue(){
        if(!isEmpty()){
            E temp = queueArray[0];
            for(int i = 1; i < queueArray.length; i ++){
                queueArray[i-1] = queueArray[i];
            }
            queueArray[size-1] = null;
            size --;
            System.out.println(" Remove: "+temp);
        }
        else{
            System.out.println("Underflow ! Unable to remove element from Queue");
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        for (int i = 0;i< size;i++) {
            System.out.println(queueArray[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray<String> queueArray = new QueueArray<>();
        queueArray.dequeue();
        System.out.println(queueArray.getSize());
        queueArray.enqueue("Nam");
        queueArray.enqueue("Ky");
        System.out.println(queueArray.getSize());
        queueArray.display();
        System.out.println("****************");
        queueArray.enqueue("Khoi");
        queueArray.enqueue("Nghia");
        System.out.println(queueArray.getSize());
        queueArray.display();
        System.out.println("****************");

        queueArray.dequeue();
        queueArray.dequeue();
        System.out.println("****************");

        queueArray.display();
        System.out.println("****************");
    }
}
