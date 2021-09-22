package cafe.plastic.leetcode;

import java.util.ArrayList;

public class s0098 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> treeList = traverse(null, root);
        int prev = -1;
        boolean firstIter = true;
        for (int node: treeList) {
            if ( !firstIter && node <= prev ) {
                return false;
            }
            firstIter = false;
            prev = node;
        }
        return true;
    }

    public ArrayList<Integer> traverse(ArrayList<Integer> list, TreeNode root) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (root.left != null) traverse (list, root.left);
        list.add(root.val);
        if (list.size() > 1 && root.val <= list.get(list.size() - 2)) {
            return list;
        }
        if (root.right != null) traverse (list, root.right);
        return list;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {

        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
