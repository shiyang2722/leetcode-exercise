package examination;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/21.
 */
public class Q144_20191121 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        proccess(root, result);
        return result;
    }

    public void proccess(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);

        if (root.left != null)  proccess(root.left, result);
        if (root.right != null) proccess(root.right, result);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();

            if (node == null) continue;

            result.add(node.val);

            if (root.right != null) stack.add(node.right);
            if (root.left != null) stack.add(node.left);
        }
        return result;
    }
}
