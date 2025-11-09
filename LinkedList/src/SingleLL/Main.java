package SingleLL;//Linkedlist traversal and length and check if element in LL

public class Main {
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

    private static int lengthOfLL(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static boolean isPresent(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if(temp.data == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
        Node head = convertArrToLL(arr);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println(lengthOfLL(head));
        System.out.println(isPresent(head, 10));
    }
}
