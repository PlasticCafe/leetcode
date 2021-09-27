package cafe.plastic.leetcode;

public class s0035 {
    int[] nums;
    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        return binarySearch(target);
    }
    int binarySearch(int target) {
        int a = 0;
        int b = nums.length - 1;
        while (true) {
            int center = a + (b - a)/2;
            if (a == b) {
                if (nums[a] < target) {
                    return a + 1;
                } else {
                    return a;
                }
            }
            if (b - a < 2) {
                if (nums[b] == target) {
                    return b;
                } else if (nums[a] == target) {
                    return a;
                } else {
                    if (nums[b] < target) {
                        return b + 1;
                    } else if (nums[a] < target){
                        return b;
                    } else {
                        return a;
                    }
                }
            }
            if (target < nums[center]) {
                b = center - 1;
            } else if (target > nums[center]){
                a = center + 1;
            } else {
                return center;
            }
        }
    }
}
