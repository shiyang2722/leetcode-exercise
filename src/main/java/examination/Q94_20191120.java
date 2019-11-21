package examination;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/20.
 */
public class Q94_20191120 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            process(root, list);
            return list;
        }

        public void process(TreeNode root, List<Integer> list) {
            if (root == null) return;
            if (root.left != null)
                process(root.left, list);
            list.add(root.val);
            if (root.right != null)
                process(root.right, list);
        }
    }

}
