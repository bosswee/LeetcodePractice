package BFSAndDFS;

import java.util.HashMap;

/**
 * Created by Wee on 2015/4/16.
 * 这道题是树中比较有难度的题目，需要根据先序遍历和中序遍历来构造出树来。这道题看似毫无头绪，其实梳理一下还是有章可循的。下面我们就用一个例子来解释如何构造出树。
 假设树的先序遍历是12453687，中序遍历是42516837。这里最重要的一点就是先序遍历可以提供根的所在，而根据中序遍历的性质知道根的所在就可以将序列分为左右子树。
 比如上述例子，我们知道1是根，所以根据中序遍历的结果425是左子树，而6837
 就是右子树。接下来根据切出来的左右子树的长度又可以在先序便利中确定左右子树对应的子序列（先序遍历也是先左子树后右子树）。
 根据这个流程，左子树的先序遍历和中序遍历分别是245和425，右子树的先序遍历和中序遍历则是3687和6837
 ，我们重复以上方法，可以继续找到根和左右子树，直到剩下一个元素。可以看出这是一个比较明显的递归过程，对于寻找根所对应的下标，
 我们可以先建立一个HashMap，以免后面需要进行线行搜索，这样每次递归中就只需要常量操作就可以完成对根的确定和左右子树的分割。
 算法最终相当于一次树的遍历，每个结点只会被访问一次，所以时间复杂度是O(n)。而空间我们需要建立一个map来存储元素到下标的映射，所以是O(n)。代码如下：
 */
public class ConstrutBTFromPreInOrder {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
                val = x;
            }
        }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null){
            return  null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);//传这么多参数是不是要重构下？。。。
    }

    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder,int inL,int inR, HashMap<Integer, Integer> map) {
        if(preL>preR||inL>inR)//DFS
            return null;
        TreeNode root = new TreeNode(preorder[preL]);//当前根节点
        int index = map.get(root.val);//map的作用就是根据先序的根节点快速找到在后序中的位置
        root.left= helper(preorder,preL+1,index-inL+preL,inorder,inL,index-1,map);
        root.right= helper(preorder,preL+index-inL+1,preR,inorder,index+1,inR,map);
        return root;
    }
}
