package cafe.plastic.leetcode;

public class s0031 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int sourceIdx = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                sourceIdx = i - 1;
                break;
            }
        }
        if (sourceIdx == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int destIdx = -1;
            for(int i = sourceIdx + 1; i < nums.length; i++) {
                if (nums[sourceIdx] < nums[i]) {
                    if (destIdx == -1) {
                        destIdx = i;
                    } else {
                        if (nums[i] <= nums[destIdx]) destIdx = i;
                    }
                }
            }
            if (destIdx != -1) {
                int temp = nums[sourceIdx];
                nums[sourceIdx] = nums[destIdx];
                nums[destIdx] = temp;
                reverse(nums, sourceIdx + 1, nums.length - 1);
            }
        }

    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
