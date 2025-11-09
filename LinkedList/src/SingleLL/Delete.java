package SingleLL;

public class Delete {
    private static Node convertArrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    private static Node removeHead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    }
    private static Node removeTail(Node head){
        if(head == null || head.next == null) return null;//head
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    private static Node removeKth(Node head, int k){
        if(head == null) return head;
        if(k == 1) {
            return head.next;
        }
        int count = 0;
        Node temp = head;
//        Node prev = null;
        while(temp != null){
            count++;
            if(count == k - 1 && temp.next!= null){
                temp.next = temp.next.next;
//                prev.next = prev.next.next;
                break;
            }
//            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static Node removeElement(Node head, int ele){
        if(head == null) return head;
        if(head.data == ele) {
            return head.next;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == ele) {
//                prev.next = temp.next;
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrToLL(arr);
//        head = removeHead(head);
//        System.out.println(head.data);
//        print(head);
//        head = removeTail(head);
        head = removeKth(head, 4);
//        head = removeElement(head, 6);
        print(head);

    }
}
