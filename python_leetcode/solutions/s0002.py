class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        carry = 0
        resultLL = ListNode()
        node = resultLL
        while(True):
            sum = 0
            sum += carry
            carry = 0

            if(l1 != None):
                sum += l1.val
                l1 = l1.next
            if(l2 != None):
                sum += l2.val
                l2 = l2.next
            if sum > 9:
                carry = 1
                sum = sum % 10
            node.val = sum
            if(l1 == None and l2 == None):
                if carry > 0:
                    node.next = ListNode()
                    node.next.val = carry
                break
            else:
                node.next = ListNode()
                node = node.next
        return resultLL