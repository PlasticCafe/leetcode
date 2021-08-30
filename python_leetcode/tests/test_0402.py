import unittest
from solutions.s0402 import Solution

class TestRemoveKDigits(unittest.TestCase):
    solver = Solution()
    def test_1(self):
        self.assertEqual(self.solver.removeKdigits('101004332234', 3), '4332234')
    
if __name__ == '__main__':
    unittest.main()