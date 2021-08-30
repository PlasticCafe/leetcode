import unittest
from solutions.s0008 import Solution

class TestExamples(unittest.TestCase):
    solver = Solution()
    def test_1(self):
        self.assertEqual(self.solver.myAtoi("42"), 42)
        self.assertEqual(self.solver.myAtoi("-13"), -13)
        self.assertEqual(self.solver.myAtoi("4193 with words"), 4193)


if __name__ == '__main__':
    unittest.main()