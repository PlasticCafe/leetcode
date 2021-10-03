package cafe.plastic.leetcode;

import java.util.LinkedList;

public class s0060 {
    public String getPermutation(int n, int k) {
        StringBuilder permutation = new StringBuilder();
        LinkedList<Integer> symbols = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            symbols.add(i);
        }
        permute(permutation, symbols, k);
        return permutation.toString();

    }

    void permute(StringBuilder permutation, LinkedList<Integer> symbols, int k) {
        if(symbols.size() == 0) return;
        if (k == 0 || symbols.size() == 1) {
            for (int symbol = symbols.size() - 1; symbol >= 0; symbol--) permutation.append(symbols.get(symbol));
            return;
        }
        for(int i = symbols.size(); i >= 0; i--) {
            int maxPerm = fac(symbols.size() - 1)*i;
            if (k == maxPerm) {
                permutation.append(symbols.remove(i - 1));
                k -= maxPerm;
                break;
            } else if (k > maxPerm) {
                permutation.append(symbols.remove(i));
                k -= maxPerm;
                break;
            }
        }
        permute(permutation, symbols, k);
    }

    int fac(int n) {
        int res = n;
        while(--n > 1) res *= n;
        return res;
    }
}
