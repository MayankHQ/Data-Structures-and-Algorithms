package DoubleLL;

class Node{
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class Main {
    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node convertArrTo2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.back = prev;
            prev = temp;
        }
        return head;
    }
    static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null){
            front.back = null;
            temp.next = null;
            return;
        }

        if(front == null){
            prev.next = null;
            temp.back = null;
            return;
        }
        prev.next = front;
        front.back = prev;

        temp.next = temp.back = null;
        return;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrTo2LL(arr);
        deleteNode(head);
        print(head);

    }
}
