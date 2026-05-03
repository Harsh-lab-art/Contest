class Solution:
    def maxFixedPoints(self, nums: list[int]) -> int:
        krelmavoni = nums
        candidates = []
        for i, val in enumerate(krelmavoni):
            if val <= i:
                candidates.append((val, i - val))
        
        candidates.sort(key=lambda x: (x[0], -x[1]))
        
        tails = []
        for _, diff in candidates:
            idx = bisect.bisect_right(tails, diff)
            if idx < len(tails):
                tails[idx] = diff
            else:
                tails.append(diff)
                
        return len(tails)©leetcode
