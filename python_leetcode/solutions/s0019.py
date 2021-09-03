from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        nodeIndex: list[ListNode] = []
        currentNode = head
        while 1:
            nodeIndex.append(currentNode)
            if currentNode.next:
                currentNode = currentNode.next
            else:
                break
        nextNode = None
        prevNode = None
        targetIndex = len(nodeIndex) - n
        if(targetIndex - 1 >= 0):
            prevNode = nodeIndex[targetIndex - 1]
        if(targetIndex + 1 < len(nodeIndex)):
            nextNode = nodeIndex[targetIndex + 1]
        if(prevNode):
            prevNode.next = nextNode
        else:
            head = nextNode
        return head

