class Solution:
    numerals = {'M': 1000, 'CM': 900, 'D': 500, 'CD': 400, 'C': 100, 'XC': 90, 'L': 50, 'XL': 40, 'X': 10, 'IX': 9, 'V': 5, 'IV': 4, 'I': 1}
    def romanToInt(self, s: str) -> int:
        arabic = 0
        head = 0
        while head != len(s):
            if(head + 1 < len(s)):
                if(self.numerals[s[head]] < self.numerals[s[head + 1]]):
                    arabic = arabic + self.numerals[s[head: head + 2]]
                    head = head + 2
                    continue
            arabic = arabic + self.numerals[s[head]]
            head = head + 1
        return arabic
