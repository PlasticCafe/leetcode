class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        nums.sort()
        minimum = 0
        firstLoop = True
        i = 0
        for i in range(len(nums) - 2):
            if(i > 0 and nums[i] == nums[i-1]): continue
            leftPointer = i + 1
            rightPointer = len(nums) - 1
            rhs = target - nums[i]
            while (leftPointer < rightPointer):
                lhs = nums[leftPointer] + nums[rightPointer]
                if firstLoop: 
                    minimum = nums[i] + nums[leftPointer] + nums[rightPointer]
                    firstLoop = False
                elif abs(target - (nums[i] + nums[leftPointer] + nums[rightPointer])) < abs(target - minimum):
                    minimum = nums[i] + nums[leftPointer] + nums[rightPointer]
                if lhs < rhs:
                    tlp = leftPointer
                    while(leftPointer < rightPointer and nums[leftPointer] == nums[tlp]):
                        leftPointer = leftPointer + 1
                elif lhs > rhs:
                    trp = rightPointer
                    while(leftPointer < rightPointer and nums[rightPointer] == nums[trp]):
                        rightPointer = rightPointer - 1
                else:
                    tlp = leftPointer
                    while(leftPointer < rightPointer and nums[leftPointer] == nums[tlp]):
                        leftPointer = leftPointer + 1

        return minimum