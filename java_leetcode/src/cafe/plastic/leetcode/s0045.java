package cafe.plastic.leetcode;

public class s0045 {
    public int jump(int[] nums) {
        int[] table = new int[nums.length];
        table[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                if (table[i] < table[i + j] || table[i + j] == 0) {
                    table[i + j] = table[i] + 1;
                }
            }
        }
        return table[nums.length - 1] - 1;
    }
}
