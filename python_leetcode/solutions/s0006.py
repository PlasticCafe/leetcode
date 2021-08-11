from math import floor
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        slen = len(s)
        if(numRows == 1 or slen == 1):
            return s
        outputString = []
        i = 1 
        while i <= slen and i <= numRows:
            outputString.append(s[i - 1])
            j = 1
            while True:
                zig = 2*((numRows - i) + (j-1)*(numRows - 1))  + i
                if(zig - 1 >= slen):
                    break
                else:
                    if(i != numRows):
                        outputString.append(s[zig - 1])
                    if(i != 1):
                        zag = 2*j*(numRows-1) + i
                        if(zag - 1 >= slen):
                            break
                        outputString.append(s[zag - 1])
                j += 1
            i += 1
        return ''.join(outputString)
