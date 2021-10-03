package cafe.plastic.leetcode;

public class s0041 {
    public int firstMissingPositive(int[] nums) {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (0 < nums[i] && nums[i] <= nums.length) {
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }
}
