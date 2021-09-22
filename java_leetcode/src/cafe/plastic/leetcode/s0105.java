package cafe.plastic.leetcode;

import java.util.HashMap;

public class s0105 {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        int[] inorder;
        int[] preorder;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 1) {
                return new TreeNode(preorder[0]);
            }
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            this.inorder = inorder;
            this.preorder = preorder;
            return getTree(inorderMap.get(preorder[0]), 0, 0, inorder.length - 1);

        }

        public TreeNode  getTree(int inorderIndex, int preorderIndex, int left, int right) {
            TreeNode node = new TreeNode(inorder[inorderIndex]);
            if (inorderIndex > left && inorderIndex < right) {
                node.left = getTree(inorderMap.get(this.preorder[preorderIndex + 1]), preorderIndex + 1, left, inorderIndex - 1);
                int rPreorderIdx = inorderIndex - left + preorderIndex + 1;
                int rInorderIdx = inorderMap.get(preorder[rPreorderIdx]);
                node.right = getTree(rInorderIdx, rPreorderIdx, inorderIndex + 1, right);
            } else if(inorderIndex > left) {
                node.left = getTree(inorderMap.get(this.preorder[preorderIndex + 1]), preorderIndex + 1, left, inorderIndex - 1);
            } else if(inorderIndex < right) {
                node.right = getTree(inorderMap.get(this.preorder[preorderIndex + 1]), preorderIndex + 1, inorderIndex + 1, right);
            }
            return node;
        }
    }
