package SingleLL;

public class Insert {
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

    private static Node insertHead(Node head, int data) {
        Node temp = new Node(data, head);
        return temp;
    }
    private static Node insertTail(Node head, int data) {
        Node newNode =  new Node(data);
        if(head == null) {
            return newNode;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    private static Node insertKth(Node head, int ele, int k){
        if(head == null) {
            if(k == 1){
                return new Node(ele);
            }
            return head;
        }
        if(k == 1){
            return new Node(ele,head);
        }
        Node temp = head;
        int count = 0;
        while(temp.next != null) {
            count++;
            if(count == k-1){
                Node newNode = new Node(ele, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    private static Node insertBeforeValue(Node head, int ele, int value){
        if(head == null) {
            return head;
        }
        if(head.data == value){
            return new Node(ele,head);
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.data == value){
                Node newNode = new Node(ele,temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrToLL(arr);
//        head = insertHead(head, 121);
//        head = new Node(100, head); //straightaway insert 100 at head
//        head = insertTail(head, 21);
//        head = insertKth(head, 79,4);
        head = insertBeforeValue(head,79, 8);
        print(head);

    }
}
