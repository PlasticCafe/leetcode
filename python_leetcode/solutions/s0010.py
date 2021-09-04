class Solution:
    def isMatch(self, string: str, pattern: str) -> bool:


        def match(string, pattern):
            if not pattern:
                return not string
            initialMatch = bool(string) and pattern[0] in {string[0], '.'}
            if len(pattern) >= 2 and pattern[1] == '*':
                if (initialMatch and match(string[1:], pattern)) or match(string, pattern[2:]):
                    return True
                else:
                    return False
            else:
                return initialMatch and match(string[1:], pattern[1:])
        return match(string, pattern)

