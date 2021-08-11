import solutions
import unittest
from solutions.s0006 import Solution

class TestExamples(unittest.TestCase):
    solver = Solution()
    def test_1(self):
        self.assertEqual(self.solver.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")