package cafe.plastic.leetcode;

public class s0053 {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int bestSum = 0;
        int minSum = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > minSum && num <= 0) {
                minSum = num;
            }
            currSum = Math.max(0, currSum + num);
            bestSum = Math.max(bestSum, currSum);
        }
        if (bestSum > 0) return bestSum;
        else return minSum;

    }
}
