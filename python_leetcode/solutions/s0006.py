from math import floor
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        slen = len(s)
        colSize = floor(slen / numRows)
        outputString = []

        i = 1
        while i < slen - 1 and i <= colSize:
            zig = 2*colSize - i 
            if(zig - 1 >= slen):
                break
            else:
                outputString.append(s[zig - 1])
                zag = 2*(colSize - 1) + i
                if(zag - 1 >= slen):
                    break
                outputString.append(s[zag - 1])
            i += 1
        return ','.join(outputString)
