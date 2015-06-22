import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wee on 2015/4/2.
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
   //Definition for binary tree
     public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;

       TreeNode(int x) {
           val = x;
       }
   }
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);//第一反应是递归DFS,然后需要传值；
    }
    public  int sum(TreeNode n,int s){
        if (n==null)return 0;
        if(n.left==null&&n.right==null)return s*10+n.val;
        return sum(n.left,s*10+n.val)+sum(n.right,s*10+n.val);
    }

    public static int sumNumbers2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> node=new LinkedList<TreeNode>();
        Queue<Integer> sum=new LinkedList<Integer>();
        node.add(root);
        sum.add(root.val);
        int res=0;
        while(!node.isEmpty()){
            TreeNode cur=node.poll();
            Integer num=sum.poll();

            if(cur.left!=null){
                node.offer(cur.left);
                sum.offer((Integer)((int)(num)*10+cur.left.val));
            }
            if(cur.right!=null){
                node.offer(cur.right);
                sum.offer((Integer)((int)(num)*10+cur.right.val));
            }
            if(cur.left==null&&cur.right==null){
                res=(int)num+res;
            }//非递归，要点是容器的选取

        }
        return res;
    }

}
