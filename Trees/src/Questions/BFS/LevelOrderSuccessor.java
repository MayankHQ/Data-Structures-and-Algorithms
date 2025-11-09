// Level order successor of a node

package Questions.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public TreeNode findSuccessor(TreeNode root, int key){
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode.left != null){
                q.offer(currNode.left);
            }
            if(currNode.right!= null){
                q.offer(currNode.right);
            }
            if(currNode.val == key){
                return q.peek();
            }
        }
        return null;
    }

}
