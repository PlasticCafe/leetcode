import unittest
from solutions.s0005 import Solution

class TestExamples(unittest.TestCase):
    solver = Solution()

    def test_1(self):
        self.assertEqual(self.solver.longestPalindrome("bababdkelkjasdf"), "babab" )
    def test_2(self):
        self.assertEqual(self.solver.longestPalindrome("909879bababdf"), "babab")
    def test_3(self):
        self.assertEqual(self.solver.longestPalindrome("395treert32"), "treert")
    def test_4(self):
        self.assertEqual(self.solver.longestPalindrome("cbbd"), "bb")
    def test_5(self):
        self.assertEqual(self.solver.longestPalindrome("bb"), "bb")
    def test_6(self):
        self.assertEqual(self.solver.longestPalindrome("aacabdkacaa"), "aca")

if __name__ == '__main__':
    unittest.main()