//101. Symmetric Tree

//Given the root of a binary tree, check whether it is a mirror of itself
//(i.e., symmetric around its center).

package Questions.BFS;
import java.util.*;

//bfs method

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.right);
        q.offer(root.left);

        while(!q.isEmpty()){
            TreeNode lefty = q.poll();
            TreeNode righty = q.poll();

            if(lefty == null && righty == null) continue;
            if(lefty == null || righty == null) return false;
            if(lefty.val != righty.val) return false;
            q.offer(lefty.left);
            q.offer(righty.right);
            q.offer(lefty.right);
            q.offer(righty.left);
        }
        return true;
    }
}

//recursive metho

class Solution {
    public boolean isSymmetric(TreeNode root){
        return root == null || helper(root.left, root.right);

    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val) return false;

        return(
                helper(left.left, right.right) && helper(left.right, right.left)
        );
    }
}