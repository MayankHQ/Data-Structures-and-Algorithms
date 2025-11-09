// 116. Populating Next Right Pointers in Each Node

//You are given a perfect binary tree where all leaves are on the same level,
//and every parent has two children. The binary tree has the following definition:

//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}

//Populate each next pointer to point to its next right node. If there is
//no next right node, the next pointer should be set to NULL.

//Initially, all next pointers are set to NULL.


package Questions.BFS;

public class Populate {
    public Node connect(Node root) {
        if (root == null) { return null; }
        Node leftmost = root;
        while (leftmost != null) {
            Node current = leftmost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
