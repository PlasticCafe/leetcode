from typing import List

class Solution: 
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        mergedSize = len(nums1) + len(nums2)
        if mergedSize == 1:
            if len(nums1): return nums1[0]
            else: return nums2[0]

        even = not mergedSize % 2 
        mergedSize = mergedSize / 2
        if even: 
            mergedSize = mergedSize + 1
        merged = 0
        idx1 = 0, idx2 = 0, count = 0, val = 0, oldval = 0
        while(count < mergedSize):
            oldVal = val
            if(idx1 >= len(nums1)):
                val = nums2[idx2]
                count += 1
                idx2 += 1
                continue
            if(idx2 >= len(nums2)):
                val = nums1[idx1]
                count += 1
                idx1 += 1
                continue
            if nums1[idx1] > nums2[idx2]:
                val = nums2[idx2]
                idx2 += 1
            else:
                val = nums1[idx2]
                idx1 += 1
            count += 1
        if even:
            merged = (val + oldVal)/2.0
        else:
            merged = val
        return merged

                



                

