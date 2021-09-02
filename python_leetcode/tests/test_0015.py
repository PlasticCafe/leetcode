import unittest
from solutions.s0015 import Solution
class TestThreeSum(unittest.TestCase):
    solver = Solution()

    def test_1(self):
        self.assertEqual(self.solver.threeSum([-1,0,1,2,-1,-4]), [[-1,-1,2],[-1,0,1]])