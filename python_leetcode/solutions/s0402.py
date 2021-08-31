class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        if k == 0: return num
        if k == len(num): return "0"
        outputDigit = []
        numIndex = 0
        while numIndex < len(num):
            if len(outputDigit) > 0 and int(num[numIndex]) < int(outputDigit[-1]) and k > 0:
                outputDigit.pop()
                k = k - 1
            else:
                outputDigit.append(num[numIndex])
                numIndex = numIndex + 1
        while(k > 0):
            outputDigit.pop()
            k = k - 1
        zeroes = 0
        for char in outputDigit:
            if char != '0': break
            zeroes = zeroes + 1
        outputDigit = "".join(outputDigit[zeroes:])
        if(outputDigit == ""): outputDigit = "0"
        return outputDigit

        

