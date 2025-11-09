package DoubleLL;

public class Delete {

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
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static Node removeHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }
    private static Node removeKth(Node head, int k){
        if(head == null){
            return null;
        }
        Node temp = head;
        int count = 0;
        while(temp.next != null){
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;
        
        if(prev == null && front == null){
            return null;
        } else if (prev == null) {
            return removeHead(head);
        } else if (front == null) {
            return removeTail(head);
        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;

        return head;

    }
    private static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

//        if (prev == null) {  // Deleting the head node
//            if (front != null) {
//                front.back = null; // Set the next node's back to null
//            }
//            temp.next = null;  // Disconnect the head node
//            return;
//        }

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
//        head = removeHead(head);
//        head = removeTail(head);
//        head = removeKth(head, 3);
        deleteNode(head);
        head = head.next;
        print(head);
    }
}
