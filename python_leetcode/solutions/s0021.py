from typing import List, Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
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
                currentNode.next = ListNode(l2.val)
                l2 = l2.next
            else:
                currentNode.next = ListNode(l1.val)
                l1 = l1.next
            currentNode = currentNode.next
        return resultHead


