//103. Binary Tree Zigzag Level Order Traversal

//Given the root of a binary tree, return the zigzag level order traversal of its nodes'
// values. (i.e., from left to right, then right to left for the next level and
// alternate between).

package Questions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int lvlSize = q.size();
            List<Integer> currlvl = new ArrayList<>();
            for(int i = 0; i < lvlSize; i++){
                TreeNode currNode = q.poll();
                if(!reverse) currlvl.add(currNode.val);
                else{
                    currlvl.add(0, currNode.val);
                }

                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right != null){
                    q.offer(currNode.right);
                }
            }
            reverse = !reverse;
            result.add(currlvl);
        }
        return result;
    }
}
