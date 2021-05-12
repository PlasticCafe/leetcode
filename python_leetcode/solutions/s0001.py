from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indices = []
        for i in range(len(nums)):
            if(nums[i] <= target):
                indices.append(i)
        for i in range(len(indices) - 1):
            for j in range(i + 1, len(indices)):
                if(nums[indices[i]] + nums[indices[j]] == target):
                    return [indices[i], indices[j]]
        return []
