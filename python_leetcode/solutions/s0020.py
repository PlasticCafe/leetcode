class Solution:
    openSet = { '{': 0, '(': 1, '[': 2}
    closeSet = {'}': 0, ')': 1, ']': 2}
    def isValid(self, s: str) -> bool:
        if len(s)  <= 1: return False
        stack = []
        for char in s: 
            if char in self.openSet:
                stack.append(char)
            elif char in self.closeSet:
                if len(stack) == 0: return False
                removed = stack.pop()
                if removed not in self.openSet: return False
                if self.openSet[removed] != self.closeSet[char]: return False
        if len(stack) != 0: return False
        return True