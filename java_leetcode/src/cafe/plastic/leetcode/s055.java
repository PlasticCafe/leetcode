package cafe.plastic.leetcode;

public class s055 {
    public boolean canJump(int[] nums) {
        boolean[] jumps = new boolean[nums.length];
        jumps[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!jumps[i]) continue;
            for (int j = 1; j <= nums[i] && i + j < jumps.length; j++) {
                jumps[i + j] = true;
                if (i + j == nums.length - 1) break;
            }
        }
        return jumps[jumps.length - 1];
    }
}
