package DoubleLL;

public class Reverse2LL {
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
    private static Node reverseLL(Node head){
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr = head;
        while(curr != null){
            prev = curr.back;
            curr.back = curr.next;
            curr.next = prev;
            curr = curr.back;
        }
        return prev.back;
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrTo2LL(arr);
        head = reverseLL(head);
        print(head);
    }
}
