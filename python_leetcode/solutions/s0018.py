class Solution:
    def fourSum(self, nums: list[int], target: int) -> list[list[int]]:
        if len(nums) < 4: return []
        nums.sort()
        quads = []
        i = 0
        for i in range(len(nums) - 3):
            if(i > 0 and nums[i] == nums[i - 1]): continue
            for j in range(i + 1, len(nums) - 2):
                if(j > i + 1 and nums[j] == nums[j-1]): continue
                leftPointer = j + 1
                rightPointer = len(nums) - 1
                rhs = target - nums[i] - nums[j]
                while (leftPointer < rightPointer):
                    lhs = nums[leftPointer] + nums[rightPointer]
                    if lhs < rhs:
                        tlp = leftPointer
                        while(leftPointer < rightPointer and nums[leftPointer] == nums[tlp]):
                            leftPointer = leftPointer + 1
                    elif lhs > rhs:
                        trp = rightPointer
                        while(leftPointer < rightPointer and nums[rightPointer] == nums[trp]):
                            rightPointer = rightPointer - 1
                    else:
                        quads.append([nums[i], nums[j], nums[leftPointer], nums[rightPointer]])
                        tlp = leftPointer
                        while(leftPointer < rightPointer and nums[leftPointer] == nums[tlp]):
                            leftPointer = leftPointer + 1
        return quads