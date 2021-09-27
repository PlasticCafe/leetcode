package cafe.plastic.leetcode;

public class s0033 {
    int[] nums;
    int pivot;
    public int search(int[] nums, int target) {
        int targetIndex = 0;
        if (nums.length == 1) {
            targetIndex = nums[0] == target ? 0 : -1;
        } else {
            this.nums = nums;
            this.pivot = findPivot();
            targetIndex = binarySearch(target);
        }
        return targetIndex;
    }
    int rotate(int index) {
       return (index + pivot) % nums.length ;
    }

    int binarySearch(int target) {
        int a = 0;
        int b = nums.length - 1;
        while (true) {
            int center = a + (b - a)/2;
            if (a == b) {
                if (target == nums[rotate(a)]){
                    return rotate(a);
                } else {
                    return -1;
                }
            }
            if (b - a < 2) {
                if (nums[rotate(b)] == target) {
                    return rotate(b);
                } else if (nums[rotate(a)] == target) {
                    return rotate(a);
                } else {
                    return -1;
                }
            }
            if (target < nums[rotate(center)]) {
                b = center - 1;
            } else if (target > nums[rotate(center)]){
                a = center + 1;
            } else {
                return rotate(center);
            }
        }
    }
    int findPivot() {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int center = left + (right - left)/2;
            if(right - left < 2) {
                return nums[right] < nums[left] ? right: left;
            } else if (nums[left] == nums[right]) {
                left++;
            } else if (nums[left] < nums[right]){
                return left;
            } else {
                if (nums[left] > nums[center]) {
                    right = center;
                } else {
                    left = center;
                }
            }
        }
    }
}
