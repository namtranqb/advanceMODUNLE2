package com.modunle2.advanced.dsa.stack;

import java.util.EmptyStackException;
import com.modunle2.advanced.dsa.linkedlist.MyLinkedList ;

public class StackMyLinkedList<E> {

    private MyLinkedList<E> stack;

    public StackMyLinkedList() {
        stack = new MyLinkedList();
    }

    public void push(E element){
        stack.addLast(element);
    }

    public E pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.remove(stack.getSize() -1);
    }

    public E peek(){
        if(stack.getSize() == 0){
            throw new EmptyStackException();
        }
        return stack.getData(size()-1);
    }

    public int size(){
        return stack.getSize();
    }

    public boolean isEmpty(){
        if(stack.getSize() == 0){
            return true;
        }
        return false;
    }

    public void display(){
        System.out.print("\nStack = ");
        if (isEmpty())
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = 0; i < stack.getSize(); i++) {
            System.out.print(stack.getData(i));
        }

    }

    public static void main(String[] args) {
        StackMyLinkedList<Integer> myStack = new StackMyLinkedList<>();
        myStack.push(9);
        myStack.push(7);
        myStack.push(5);
        myStack.push(3);
        myStack.push(1);
        myStack.display();
        System.out.println("\n*******************");

        System.out.println(myStack.pop());
        myStack.display();
        System.out.println("\n*******************");

        System.out.println(myStack.peek());
        myStack.display();
        System.out.println("\n*******************");
    }
}
