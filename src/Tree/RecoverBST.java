package Tree;

import java.util.ArrayList;

/**
 * Created by Wee on 2015/4/21.
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 这道题是要求恢复一颗有两个元素调换错了的二叉查找树。一开始拿到可能会觉得比较复杂，其实观察出规律了就比较简单。主要还是利用二叉查找树的主要性质，
 就是中序遍历是有序的性质。那么如果其中有元素被调换了，意味着中序遍历中必然出现违背有序的情况。那么会出现几次呢？有两种情况，
 如果是中序遍历相邻的两个元素被调换了，很容易想到就只需会出现一次违反情况，只需要把这个两个节点记录下来最后调换值就可以；
 如果是不相邻的两个元素被调换了，举个例子很容易可以发现，会发生两次逆序的情况，那么这时候需要调换的元素应该是第一次逆序前面的元素，
 和第二次逆序后面的元素。比如1234567,1和5调换了，会得到5234167，逆序发生在52和41，我们需要把4和1调过来，那么就是52的第一个元素，
 41的第二个元素调换即可。
 搞清楚了规律就容易实现了，中序遍历寻找逆序情况，调换的第一个元素，永远是第一个逆序的第一个元素，
 而调换的第二个元素如果只有一次逆序，则是那一次的后一个，如果有两次逆序则是第二次的后一个。算法只需要一次中序遍历，所以时间复杂度是O(n)，
 空间是栈大小O(logn)。



 */
public class RecoverBST {//其他方法：Morris Traversal方法遍历二叉树（非递归，不用栈，O(1)空间）
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void recoverTree(TreeNode root) {//非 constant space

        if(root==null)return;
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);//用来存储前一个节点
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();//存储要变换的节点，1-2个
        helper(root,pre,res);//DFS中序遍历
        if (res.size()>0){
            int temp = res.get(0).val;
            res.get(0).val=res.get(1).val;
            res.get(1).val=temp;//节点变换，相邻那么和前一个节点交换，否则。。。
        }



    }

    private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res) {
        if (root==null){
            return;
        }
        helper(root.left,pre,res);
        if (pre.get(0)!=null&&pre.get(0).val>root.val){
            if (res.size()==0){
                res.add(pre.get(0));//第一次违规的第一个元素
                res.add(root);
            }else{
                res.set(1,root);//如果有第二次违规
            }
        }
        pre.set(0,root);
        helper(root.right,pre,res);

    }
}
