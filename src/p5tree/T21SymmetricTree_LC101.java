package p5tree;

import java.util.LinkedList;
import java.util.Queue;

public class T21SymmetricTree_LC101 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        System.out.println(isSymmetric2(t1));
    }

    // 解法1：递归
    public static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return check(root.left, root.right);
    }

    public static boolean check(TreeNode left, TreeNode right){


        if(left == null && right == null){
            return true;
        }

        if(left != null || right != null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }

    // 解法2：利用队列，层序遍历
    // right和left容易搞混，最好不要复制代码，而要一行一行的写
    public static boolean isSymmetric2(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return true;
        }

        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);

        while(!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            if(queue.isEmpty()) return false;
            TreeNode p2 = queue.poll();
            if(p1.val != p2.val) return false;

            if(p1.left != null && p2.right != null){
                queue.add(p1.left);
                queue.add(p2.right);
            }else if(p1.left != null || p2.right != null){
                return false;
            }

            if(p1.right != null && p2.left != null){
                queue.add(p1.right);
                queue.add(p2.left);
            }else if(p1.right != null || p2.left != null){
                return false;
            }



        }



        return true;
    }

}
