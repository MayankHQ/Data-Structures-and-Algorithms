package DoubleLL;

public class Insert {
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

    private static Node insertHead(Node head, int val){
        if(head == null){
            return new Node(val);
        }
        Node newHead = new Node(val, head, null);
        head.back = newHead;
        return newHead;
    }
    private static Node insertBeforeTail(Node head, int val){
        if(head == null){
            return new Node(val);
        }
        Node temp = head;
        Node prev = null;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        Node newT = new Node(val, temp, prev);
        temp.back = newT;
        prev.next = newT;

        return head;
    }
    private static Node insertBeforeKth(Node head, int val, int k){
        if(head == null){
            return new Node(val);
        }
        if(k == 1) return insertHead(head, val);
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            if(count == k){
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newT = new Node(val, temp, prev);
        temp.back = newT;
        prev.next = newT;

        return head;
    }
    static void insertNode(Node node, int val){
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        node.back = newNode;
        prev.next = newNode;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrTo2LL(arr);
//        head = insertBeforeKth(head, 199,2);
        insertNode(head.next, 99);
        print(head);
    }
}
