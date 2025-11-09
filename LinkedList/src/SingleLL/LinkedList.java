package SingleLL;//Creating a LinkedList

class Node{
    int data;
    Node next;
    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {2,5,9,3};
        Node x = new Node(arr[0]);
        Node y = x;
        System.out.println(y);
    }
}