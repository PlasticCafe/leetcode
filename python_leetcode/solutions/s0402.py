class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        return self.zeroStrip(self, num, k)[0]

    def zeroStrip(self, num:str, k: int) -> tuple(str, int):
        for i in range(min(k, len(str) - 1), -1): 
            if(num[i] == '0'):
                while(num[i] == '0' and i >= 0):
                    i = i - 1
                k = i + 1
                num = num[i:]
                break
        k = k - i 
        for i in range(len(num)):
            if num[i] != '0':
                num = num[i:]
                break
        return (num, k)
            
