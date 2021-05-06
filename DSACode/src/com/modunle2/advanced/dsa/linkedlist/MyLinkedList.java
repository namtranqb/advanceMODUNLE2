package com.modunle2.advanced.dsa.linkedlist;

public class MyLinkedList<E> {


    public class Node<E> {
        private Node next;
        private E value;

        public Node( E value) {
            this.next = null;
            this.value = value;
        }
        public E getValue(){
            return this.value;
        }

    }
    public Node head;
    public int size = 0;

    public MyLinkedList() {
    }

    public int getSize(){
        return size;
    }

    public E getData(int index){
        Node temp = head;
        for(int i = 0;i< index;i++){
            temp = temp.next;
        }
        return (E) temp.getValue();
    }
    public boolean isEmpty(){
        return (this.getSize() == 0) ? true : false;
    }

    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        size++;
    }

    public void addLast(E element){
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(element);
        temp.next = newNode;
        newNode.next = null;
        size ++;

    }

    public void add(int index, E element){
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        else
            if(index == 0)
                addFirst(element);
            else
                {
                Node temp = head;
                Node holder;
                for (int i = 0; i < index -1; i++) {
                    temp = temp.next;
                }
                if(temp.next == null){
                    addLast(element);
                }else {
                    holder = temp.next;
                    Node newNode = new Node(element);
                    temp.next = newNode;
                    newNode.next = holder;
                    size++;
                }
        }
    }

    public boolean contains(E element){
        Node temp = head;
        while (temp != null){
            if(temp.getValue() == element)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public String indexOf(E element){
        Node temp = head;
        for(int i = 0; i< getSize();i++){
            if(temp.getValue() == element){
                return "Found "+element+" at index: "+i;
            }
            temp = temp.next;
        }
        return element+" is NOT found";
    }

    public E remove(int index){
        if(index < 0 || index > getSize()){
            throw  new IndexOutOfBoundsException();
        }
        Node temp = head;
        E element;
        if(index == 0){
            element = (E) temp.getValue();
           head = head.next;
        }else{
            for(int i = 0; i < index-1 && temp.next != null; i++){
                temp = temp.next;
            }
            Node holder = temp.next;
            element = (E) holder.getValue();
            temp.next = holder.next;
        }
        size --;
        return (E) element;
    }

    public boolean remove(E element){
        if(head.value == element){
            remove(0);
            return true;
        }else{
            Node temp = head;
            while (temp.next != null){
                if(temp.next.getValue() == element){
                    Node holder = temp.next;
                    temp.next = holder.next;
                    size --;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public MyLinkedList<E> clone(){
        if(size == 0){
            throw new NullPointerException();
        }
        MyLinkedList<E> temp = new MyLinkedList<>();
        Node tempNode = head;
        temp.addFirst((E) tempNode.value);
        tempNode = tempNode.next;
        while (tempNode != null){
            temp.addLast((E) tempNode.value);
            tempNode = tempNode.next;
        }
        return temp;
    }


    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.getValue()+" ");
            temp = temp.next;

        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst("Ha");
        myLinkedList.addFirst("Son");
        myLinkedList.addFirst("Quoc");
        myLinkedList.addFirst("Nam");
        myLinkedList.display();
        System.out.println("\n*******************");

        myLinkedList.add(4,"Nhau");
        myLinkedList.display();
        System.out.println("\n*******************");

        System.out.println(myLinkedList.getData(2));
        myLinkedList.display();
        System.out.println("\n*******************");

        myLinkedList.addLast("Say");
        myLinkedList.addLast("Bat");
        myLinkedList.addLast("Tinh");
        myLinkedList.display();
        System.out.println("\n*******************");

        myLinkedList.remove(4);
        myLinkedList.display();
        System.out.println("\n*******************");

        System.out.println(myLinkedList.contains("Son"));
        System.out.println("\n*******************");

        System.out.println(myLinkedList.indexOf("Quoc"));
        System.out.println(myLinkedList.indexOf("Hoa"));
        System.out.println("\n*******************");

        MyLinkedList<String> myLinkedList1 = myLinkedList.clone();
        myLinkedList1.display();
    }
}
