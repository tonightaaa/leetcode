package p5tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T20PostTree_LC145 {
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if( root.right == null || root.right == pre){
                res.add(root.val);
                pre = root;
                root = null;
            }else{
                stack.push(root);
                root = root.right;
            }

        }



        return res;
    }

}
