import math
class Solution:
    def reverse(self, x: int) -> int:
        maxint_32 = 2**31 - 1
        minint_32 = -1*(2**31)
        negative = True if x < 0 else False
        if(negative): x *= -1
        if(x < 10):
            return x
        reversedInt = 0
        while x >= 1:
            reversedInt *= 10
            reversedInt += x%10
            x //= 10
        if(negative): reversedInt *= -1
        if(reversedInt > maxint_32 or reversedInt < minint_32):
            reversedInt = 0
        return reversedInt

