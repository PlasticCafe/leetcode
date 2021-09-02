class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        if len(nums) < 3: return []
        nums.sort()
        triplets = []
        i = 0
        for i in range(len(nums) - 2):
            if(i > 0 and nums[i] == nums[i-1]): continue
            leftPointer = i + 1
            rightPointer = len(nums) - 1
            rhs = nums[i] * -1
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
                    triplets.append([nums[i], nums[leftPointer], nums[rightPointer]])
                    tlp = leftPointer
                    while(leftPointer < rightPointer and nums[leftPointer] == nums[tlp]):
                        leftPointer = leftPointer + 1
        return triplets

