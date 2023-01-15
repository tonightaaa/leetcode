package p5tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T18InorderTree_LC94 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        inorderTraversal(t1);
    }

    // 自己想的过程，有些复杂
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(root.left != null){
            root = root.left;
            stack.push(root);
        }

        while(!stack.empty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null){
                temp = temp.right;
                stack.push(temp);
                while(temp.left != null){
                    temp = temp.left;
                    stack.add(temp);
                }
            }
        }

        return res;
    }

    // leetcode官方答案，很简洁
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
