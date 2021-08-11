class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if(length == 1): return s[0]
        longest = ''
        for i in range(0, length):
            tpalindrome = self.getPalindrome(i, i, s)
            if(i < length - 1) :
                tepalindrome = self.getPalindrome(i, i + 1, s)
                if len(tepalindrome) > len(tpalindrome):
                    tpalindrome = tepalindrome
            if(len(tpalindrome) > len(longest)):
                longest = tpalindrome
        return longest        
    def getPalindrome(self, lhs: int, rhs: int, s: str) -> str:
        length = len(s)
        found = False
        if(s[lhs] == s[rhs]): 
            found = True
        else:
            return ''
        while(lhs > 0 and rhs < length - 1):
            if(s[lhs - 1] == s[rhs + 1]):
                lhs -= 1
                rhs += 1
                found = True
            else: break
        return s[lhs:rhs + 1] if found else ''
