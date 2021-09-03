class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if len(strs) == 1:
            return strs[0]
        elif len(strs[0]) == 0:
            return ''
        prefix = []
        char = 0
        while 1:
            count = 0
            for i in range(len(strs)):
                if char >= len(strs[i]): break
                elif strs[i][char] == strs[0][char]: count = count + 1
                else: break
            if count < len(strs): break
            prefix.append(strs[0][char])
            char = char + 1
        return ''.join(prefix)
                