package examination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/21.
 */
public class Q590_20191121 {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Solution {
        public List<Integer> postorder2(Node root) {
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<Node> stack = new LinkedList<>();

            stack.add(root);
            while (!stack.isEmpty()) {
                Node last = stack.peekLast();
                if (last.children != null) {
                    List<Node> childrens = last.children;
                    for (Node node : childrens) {
                        stack.add(node);
                    }
                } else {
                    Node node = stack.pollLast();
                    if (node != null) result.add(node.val);
                }
            }
            return result;
        }

        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            process(root, result);
            return result;
        }

        public void process(Node root, List<Integer> result) {
            if (root == null) return;

            for (Node node : root.children) {
                process(node, result);
            }

            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        List<Node> fc = new ArrayList<>();
        Node node3 = new Node(3);
        fc.add(node3);
        fc.add(new Node(2));
        fc.add(new Node(4));
        node.children = fc;

        List<Node> sc = new ArrayList<>();
        sc.add(new Node(5));
        sc.add(new Node(6));

        node3.children = sc;

        Solution solution = new Solution();
        solution.postorder2(node);
    }
}


