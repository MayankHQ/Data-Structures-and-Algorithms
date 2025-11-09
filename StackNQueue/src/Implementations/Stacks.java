package Implementations;

import java.util.Stack;

/*
public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        System.out.println(stack.peek()); // prints last item
        System.out.println(stack.pop()); // removes last item
        System.out.println(stack);
    }
}
*/


class stack{
    int[] arr = new int[10];
    int top = -1;
    void push(int x){
        if(top >= 9) System.out.println("Stack is full");
        top++;
        arr[top] = x;
    }
    void pop(){
        if(top == -1) System.out.println("Stack is empty");
        top--;
    }
    int peek(){
        if(top == -1) System.out.println("Stack is empty");
        return arr[top];
    }
    int size(){
        return top + 1;
    }
    void printStack(){
        for(int i = 0; i <= top ; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
 public class Stacks {
    public static void main(String[] args) {
        stack st = new stack();
        st.push(1);
        st.push(2);
        st.push(3);

        st.pop();

        st.printStack();
    }
 }
