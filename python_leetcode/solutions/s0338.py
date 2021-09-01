class Solution:
    def countBits(self, n: int) -> list[int]:
        if n == 0: return [0]
        if n == 1: return [0, 1]
        ans = [0, 1]
        exp = 2
        i = 2
        while(i <= n):
            if i == exp*2:
                exp = exp*2
                ans.append(1)
            else:
                ans.append(1 + ans[i - exp])
            i = i+1
        return ans
