import unittest
from solutions.s0003 import Solution
class TestLongestSubstring(unittest.TestCase):
    def test_length(self):
        solver = Solution()
        self.assertEqual(solver.lengthOfLongestSubstring("abba"), 2)
        self.assertEqual(solver.lengthOfLongestSubstring("aab"), 2)
        self.assertEqual(solver.lengthOfLongestSubstring("au"), 2)
        self.assertEqual(solver.lengthOfLongestSubstring("abcabcbb"), 3)
        self.assertEqual(solver.lengthOfLongestSubstring("bbbbb"), 1)
        self.assertEqual(solver.lengthOfLongestSubstring("pwwkew"), 3)
        self.assertEqual(solver.lengthOfLongestSubstring(""), 0)

if __name__ == '__main__':
    unittest.main()