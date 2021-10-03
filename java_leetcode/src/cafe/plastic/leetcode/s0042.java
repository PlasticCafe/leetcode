package cafe.plastic.leetcode;

public class s0042 {
    public int trap(int[] height) {
        int totalVolume = 0;
        int[] possibleWater = new int[height.length];
        int maxHeight = 0;
        for(int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) maxHeight = height[i];
            possibleWater[i] = maxHeight - height[i];
        }
        maxHeight = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > maxHeight) maxHeight = height[i];
            totalVolume += Math.min(possibleWater[i], maxHeight - height[i]);
        }
        return totalVolume;
    }
}
