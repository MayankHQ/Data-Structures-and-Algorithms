//637. Average of Levels in Binary Tree

//Given the root of a binary tree, return the average value of the nodes on each level
//in the form of an array. Answers within 10-5 of the actual answer will be accepted.

package Questions.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgLevel {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            double avg = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode currNode = q.poll();
                avg = avg + currNode.val;
                if(currNode.left != null){
                    q.offer(currNode.left);
                }
                if(currNode.right!= null){
                    q.offer(currNode.right);
                }
            }
            result.add(avg/levelSize);
        }
        return result;

    }
}
