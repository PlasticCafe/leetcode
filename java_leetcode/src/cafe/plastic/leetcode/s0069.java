package cafe.plastic.leetcode;

public class s0069 {
    public int mySqrt(int x) {
        if (x == 2) return 1;
        if (x < 2) return x;
        boolean wasLesser = false;
        long guess = x/2;
        while(true) {
            if (guess*guess > x) {
                if(wasLesser) {
                    guess--;
                    break;
                }
                guess /=2;
            } else if (guess*guess < x) {
                guess++;
                wasLesser = true;
            } else{
                break;
            }
        }
        return (int)guess;
    }
}
