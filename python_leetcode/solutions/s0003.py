class Solution:
    def lengthOfLongestSubstring(self, input: str) -> int:
        if len(input) < 2:
            return len(input)
        start = 0
        head = 0
        longest = (0, 0)
        seenDict = {}
        while head < len(input):
            if(input[head] not in seenDict):
                seenDict[input[head]] = head
                head += 1
            else:
                if((head - start) > (longest[1] - longest[0])):
                    longest = (start, head)
                start = seenDict[input[head]] + 1
                head = start
                seenDict = {}
        if((head - start) > (longest[1] - longest[0])):
            longest = (start , head)
        return longest[1] - longest[0] 



