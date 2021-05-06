package com.modunle2.advanced.dsa.stack;

import java.util.Arrays;

public class StackArray<E> {
    public int size = 0;
    public E[] stackArray;


    public StackArray() {
        stackArray =(E[]) new Object[3];
    }

    public void ensureCapacity(){
        int newSize = stackArray.length * 2;
        stackArray = Arrays.copyOf(stackArray,newSize);
    }
    public boolean isEmpty(){
        return (getSize() == 0) ? true : false;
    }

    public int getSize(){
        return size;
    }


    public void push(E element){
        if(getSize() == stackArray.length) {
            ensureCapacity();
        }
        stackArray[size] = element;
        size ++;
    }

    public String pop(){
        if(isEmpty()){
            return "Stack is Empty";
        }else{
            E temp = stackArray[size - 1] ;
            size --;
            stackArray[size] = null;

            return "Remove "+temp;
        }
    }

    public String peek(){
        if(isEmpty()){
            return "Stack is Empty";
        }else{
            E temp = stackArray[size - 1] ;
            return "Peek: "+temp;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        for (int i = 0;i< size;i++) {
            System.out.println(stackArray[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        StackArray<String> myStack = new StackArray<>();
        System.out.println(myStack.getSize());
        System.out.println("\n*************************");
        myStack.push("Quang");
        myStack.push("Huy");
        System.out.println(myStack.getSize());
        myStack.display();
        System.out.println("\n*************************");
        myStack.push("Nghia");
        myStack.display();
        System.out.println("\n*************************");
        myStack.pop();
        myStack.pop();
        myStack.display();
        System.out.println("\n*************************");
        myStack.push("Hoa");
        myStack.push("Chau");
        myStack.push("Long");
        myStack.push("Thien");
        System.out.println(myStack.getSize());
        myStack.display();
        System.out.println("*************************");

    }
}
