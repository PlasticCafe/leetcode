package cafe.plastic.leetcode;

public class s0026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int insertCursor = 0;
        for(int swapCursor = 1; swapCursor < nums.length; swapCursor++) {
            if(nums[insertCursor] != nums[swapCursor]) {
                insertCursor++;
                nums[insertCursor] = nums[swapCursor];
            }
        }
        return insertCursor + 1;
    }
}
