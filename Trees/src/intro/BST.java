package intro;

public class BST {
    public class Node{
        int value;
        Node left;
        Node right;
        int height;

        public Node(int key){
            this.value = key;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public BST(){

    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int key){
        root = insert(key, root);
    }
    private Node insert(int key, Node node){
        if (node == null) {
            return new Node(key);
        }

        if (key < node.value) {
            node.left = insert(key, node.left);
        } else if (key > node.value) {
            node.right = insert(key, node.right);
        }

        // Update height after insertion
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }


}
