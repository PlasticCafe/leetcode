
import re
class Solution:
    maxint_32 = 2**31 - 1
    minint_32 = -1*(2**31)

    def myAtoi(self, s:str) -> int:
        if(len(s) == 0):
            return 0
        parseHead = 0
        negative = False
        result = 0
        numMatcher = re.compile('\d')
        signMatcher = re.compile('[\+\-]')
        s = s.lstrip(' ')
        if(signMatcher.match(s[parseHead])):
            if s[parseHead] == '-' : negative = True
            parseHead += 1
        while numMatcher.match(s[parseHead]):
            result *= 10
            result += ord(s[parseHead]) - 48
            parseHead += 1
            if parseHead >= len(s): break
        if(negative): result *= -1
        if(result < self.minint_32): result = self.minint_32 
        elif(result > self.maxint_32): result = self.maxint_32
        return result