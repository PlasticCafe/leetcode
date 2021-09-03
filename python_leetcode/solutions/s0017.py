class Solution:
    phoneDict = {'2': 'abc', '3': 'def', '4': 'ghi', '5': 'jkl', '6': 'mno', '7': 'pqrs', '8': 'tuv', '9': 'wxyz'}
    def letterCombinations(self, digits: str) -> list[str]:
        if len(digits) == 0:
            return []
        output = []
        def dial(digit: int, number: str):
            if digit == len(digits): 
                output.append(number)
                return
            for letter in self.phoneDict[digits[digit]]:
                dial(digit + 1, number + letter)
        
        dial(0, '')
        return output

                




