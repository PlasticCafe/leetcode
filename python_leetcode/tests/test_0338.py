import unittest
from solutions.s0338 import Solution
class CountOnes(unittest.TestCase):
    solver = Solution()

    def test_1(self):
        self.assertEqual(self.solver.countBits(5), [0,1,1,2,1,2])
        