//993. Cousins in Binary Tree

//Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
//return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

//Two nodes of a binary tree are cousins if they have the same depth with different parents.

//Note that in a binary tree, the root node is at the depth 0, and children of
//each depth k node are at the depth k + 1.

package Questions.BFS;
import java.util.*;

//Recursive method
public class Cousin {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return(
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }
    public TreeNode findNode(TreeNode node, int z){
        if(node == null) return null;
        if(node.val == z) return node;
        TreeNode n = findNode(node.left, z);
        if(n != null){
            return n;
        }
        return findNode(node.right, z);
    }
    public boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }

        return(
                (node.left == x && node.right == y) || (node.left == y && node.right == x) ||
                        isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }
    public int level(TreeNode root, TreeNode curr, int lev){
        if(root == null) return 0;
        if(root == curr){
            return lev;
        }
        int l = level(root.left, curr, lev + 1);
        if(l != 0){
            return l;
        }

        return level(root.right, curr, lev + 1);
    }
}


//BFS method

class Cousin2{
    public boolean isCousins(TreeNode root, int x, int y){
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int children = 0;

        while(!q.isEmpty()){
            int level = q.size();
            for(int i = 0; i < level; i++){
                TreeNode temp = q.poll();
                int sameParent = 0;
                if(temp.left != null){
                    if(temp.left.val == x || temp.left.val == y){
                        sameParent++;
                        children++;
                    }
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    if(temp.right.val == x || temp.right.val == y){
                        sameParent++;
                        children++;
                    }
                    q.offer(temp.right);
                }
                if(sameParent == 2){
                    return false;
                }
            }
            if(children == 2) return true;
            if(children == 1) return false;
        }
        return false;
    }
}

