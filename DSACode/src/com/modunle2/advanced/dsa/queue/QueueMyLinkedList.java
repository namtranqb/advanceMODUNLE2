package com.modunle2.advanced.dsa.queue;
public class QueueMyLinkedList<E> {
    private Node front;
    private Node rear;


    public class Node<E> {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
        public E getValue(){
            return this.value;
        }


    }
    public QueueMyLinkedList() {
        this.front = null;
        this.rear = null;
    }


    public boolean isEmpty(){
        return (this.front == null)? true : false;

    }

    public void enqueue(E e){
        Node temp = new Node(e);
        if(this.front == null){
            this.front = this.rear = temp;
        }else {
            this.rear.next = temp;
            this.rear = temp;
        }
    }

    public E dequeue(){
        if(isEmpty()){
            return (E) "Queue is empty";
        }
        Node temp = this.front;
        this.front = this.front.next;
       this.rear = null;
        return (E) temp.value;


    }

    public void display(){
        Node temp = this.front;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public E peek(){
        if(isEmpty()) {
            return null;
        }
        return (E) this.front.value;
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
