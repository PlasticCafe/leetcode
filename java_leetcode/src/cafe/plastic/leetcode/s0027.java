package cafe.plastic.leetcode;

public class s0027 {
    public int removeElement(int[] nums, int val) {
        int insertCursor = 0;
        for(int swapCursor = 0; swapCursor < nums.length; swapCursor++) {
            if(nums[swapCursor] != val) {
                nums[insertCursor] = nums[swapCursor];
                insertCursor++;
            }
        }
        return insertCursor;
    }
}
