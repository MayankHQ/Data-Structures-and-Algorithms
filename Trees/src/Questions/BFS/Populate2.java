package Questions.BFS;

import java.util.LinkedList;
import java.util.Queue;

//this solution for both populate 1 and 2 brute force by bfs method

class Populate2 {
     public Node connect(Node root) {
         if(root == null) return null;
         Queue<Node> q = new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
             int lvl = q.size();
             Node dummy = new Node(0);
             while(lvl-->0){
                 Node curr = q.poll();
                 dummy.next = curr;
                 dummy = curr;
                 if(curr.left != null) q.offer(curr.left);
                 if(curr.right != null) q.offer(curr.right);
             }
         }
         return root;
     }
 }

 // recursive approach

class Solution2 {
    public Node connect(Node root) {
        if(root == null) return null;
        Node curr = root;
        while(curr != null){
            Node dummy = new Node(0);
            Node temp = dummy;
            while(curr != null){
                if(curr.left != null){
                    temp.next = curr.left;
                    temp = temp.next;
                }
                if(curr.right != null){
                    temp.next = curr.right;
                    temp = temp.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}