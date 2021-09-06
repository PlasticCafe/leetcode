from typing import List, Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        n = len(lists)
        if n == 0: return None
        elif n == 1: return lists[0]
        result = self.mergeTwoLists(lists[0], lists[1])
        if n == 2: return result
        for i in range(2, n):
            result = self.mergeTwoLists(result, lists[i])
        return result

    def mergeTwoLists(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1:
            return l2
        elif not l2:
            return l1
        
        resultHead = None
        currentNode = None
        if l1.val > l2.val:
            currentNode = ListNode(l2.val)
            l2 = l2.next
        else:
            currentNode = ListNode(l1.val)
            l1 = l1.next
        resultHead = currentNode

        while l1 or l2:
            if not l1:
                currentNode.next = l2
                break
            elif not l2:
                currentNode.next = l1
                break
            if(l1.val > l2.val):
                currentNode.next = l2
                l2 = l2.next
            else:
                currentNode.next = l1
                l1 = l1.next
            currentNode = currentNode.next
            currentNode.next = None
        return resultHead


