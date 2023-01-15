package p5tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T19PreorderTree_LC144 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.empty()){
            while (root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            root = root.left;
        }


        return list;
    }
}
