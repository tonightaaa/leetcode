package p5tree;

import java.util.LinkedList;
import java.util.Queue;

public class T22DepthTree_LC104 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(-1);
        TreeNode t7 = new TreeNode(5);
        TreeNode t8 = new TreeNode(1);
        TreeNode t9 = new TreeNode(6);
        TreeNode t10 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t5.right = t9;
        t6.right = t10;

        System.out.println(maxDepth2(t1));
    }

    // 解法1：递归
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left > right ? left : right) + 1;
    }

    // 解法2：层次遍历，记录层次数
    public static int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int deep = 0;
        if (root == null){
            return deep;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            deep++;
        }

        return deep;
    }
}
