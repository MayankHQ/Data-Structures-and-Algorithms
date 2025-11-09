package Questions.DFS;

public class Invert {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;

        return root;
    }
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) return null;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            TreeNode curr = q.poll();
//            TreeNode temp = curr.left;
//            curr.left = curr.right;
//            curr.right = temp;
//            if(curr.left != null) q.offer(curr.left);
//            if(curr.right != null) q.offer(curr.right);
//        }
//        return root;
//    }
}
