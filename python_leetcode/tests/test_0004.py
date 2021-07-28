import unittest
from solutions.s0004 import Solution

class TestExamples(unittest.TestCase):
    solver = Solution()
    def test_1(self):
        self.assertEqual(self.solver.findMedianSortedArrays([1, 3], [2]), 2.0)
        self.assertEqual(self.solver.findMedianSortedArrays([1, 2], [3, 4]), 2.5)
        self.assertEqual(self.solver.findMedianSortedArrays([0, 0], [0, 0]), 0.0)
        self.assertEqual(self.solver.findMedianSortedArrays([2], []), 2.0)
if __name__ == '__main__':
    unittest.main()