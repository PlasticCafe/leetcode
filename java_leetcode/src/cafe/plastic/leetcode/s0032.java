package cafe.plastic.leetcode;

import java.util.Stack;

public class s0032 {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int longest = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.empty()) {
                        if ((i - stack.peek()) > longest) {
                            longest = i - stack.peek();
                        }
                } else {
                    stack.push(i);
                }
            }
        }
        return longest;
    }
}
