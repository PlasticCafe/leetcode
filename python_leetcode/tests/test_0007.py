import unittest
from solutions.s0007 import Solution
class TestExamples(unittest.TestCase):
    solver = Solution()

    def test_1(self):
        self.assertEqual(self.solver.reverse(123), 321)
        self.assertEqual(self.solver.reverse(-123), -321)
    def test_2(self):
        self.assertEqual(self.solver.reverse(1563847412), 0)

if __name__ == '__main__':
    unittest.main()