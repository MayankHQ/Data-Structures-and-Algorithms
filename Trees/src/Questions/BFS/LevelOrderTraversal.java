// 102. Binary Tree Level Order Traversal

package Questions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int lvlSize = q.size();
            List<Integer> currlvl = new ArrayList<>();
            for(int i = 0; i < lvlSize; i++){
                TreeNode currNode = q.poll();
                currlvl.add(currNode.val);
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            result.add(currlvl);
        }
        return result;
    }
}
