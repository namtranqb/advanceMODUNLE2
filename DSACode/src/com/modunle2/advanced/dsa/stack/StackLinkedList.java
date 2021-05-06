package com.modunle2.advanced.dsa.stack;
import java.util.EmptyStackException;
import  java.util.LinkedList;
public class StackLinkedList<E> {

    private LinkedList<E> stack;

    public StackLinkedList() {
        stack = new LinkedList<>();
    }

    public void push(E element){
        stack.addLast(element);
    }

    public E pop(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }

    public E peek(){
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        }
        return false;
    }

    public void display(){
        System.out.print("\nStack = ");
        if (stack.isEmpty())
        {
            System.out.print("Empty\n");
            return ;
        }
        for(E o : stack)
        System.out.print(o + " ");
    }

    public static void main(String[] args) {
        StackLinkedList<Integer> stackLinkedList = new StackLinkedList<>();
        stackLinkedList.push(9);
        stackLinkedList.push(7);
        stackLinkedList.push(5);
        stackLinkedList.push(3);
        stackLinkedList.push(1);
        stackLinkedList.display();
        System.out.println("\n*******************");

        System.out.println(stackLinkedList.pop());
        stackLinkedList.display();
        System.out.println("\n*******************");

        System.out.println(stackLinkedList.peek());
        stackLinkedList.display();
        System.out.println("\n*******************");
    }
}
