/*
二叉树中和为某一值的路径
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点
值的和为输入整数的所有路径。路径定义为从树的
根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            ArrayList<ArrayList<Integer>> pathlist = new ArrayList<ArrayList<Integer>>();
            ArrayList<TreeNode>list = new ArrayList<TreeNode>();
            if(root==null)
                    return pathlist;
            else{
                    list.add(root);
                    calSum(root,target,list,pathlist,root.val);
            }
            return pathlist;
    }

    public static void calSum(TreeNode node,int target,ArrayList<TreeNode>list,ArrayList<ArrayList<Integer>> pathlist,int sum){
            if(node.left==null&&node.right==null){
                    if(sum==target){
                            ArrayList<Integer>vallist = new ArrayList<Integer>();
                            for(TreeNode treeNode:list)
                                    vallist.add(treeNode.val);
                            pathlist.add(vallist);
                    }
            }
            if(node.left!=null){
                    sum = 0;
                    for(TreeNode treeNode:list)
                            sum+=treeNode.val;
                    list.add(node.left);
                    sum+=node.left.val;
                    calSum(node.left,target,list,pathlist,sum);
            }
            if(node.right!=null){
                    sum = 0;
                     for(TreeNode treeNode:list)
                             sum+=treeNode.val;
                    list.add(node.right);
                    sum+=node.right.val;
                    calSum(node.right,target,list,pathlist,sum);
            }
            list.remove(node);
    }

    public static void main(String [] args){
            TreeNode node1 = new TreeNode(1);
            TreeNode node2 = new TreeNode(2);
            TreeNode node3 = new TreeNode(3);
            TreeNode node4 = new TreeNode(4);
            TreeNode node5 = new TreeNode(5);
            TreeNode node6 = new TreeNode(3);
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = node5;
            node3.left = node6;
            System.out.println(FindPath(node1,3)); 
    }
}
/*
几乎是做崩溃了，发现有些时候，大体上的思路是有的，但是代码实现起来相当的困难，逻辑结构处理不好，做了这么多题
感觉提升并不是很大，完全就是改代码，而不是有着一个完整的思路，然后去实现，现在需要对题目进行一些总结，找找感觉了。
 */
