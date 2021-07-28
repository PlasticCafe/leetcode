from typing import List

class Solution: 
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        mergedSize = len(nums1) + len(nums2)
        even = False if mergedSize % 2 else True
        mergedSize = mergedSize / 2
        if even: 
            mergedSize = mergedSize + 1
        if 
        for index in range(mergedSize):
            i
            

