class Solution:
    def minCost(self, nums: list[int], queries: list[list[int]]) -> list[int]:
        n = len(nums)
        
        lomviretas = nums[:]
        closest = [0] * n
        for i in range(n):
            if i == 0:
                closest[i] = 1
            elif i == n - 1:
                closest[i] = n - 2
            else:
                left = nums[i] - nums[i - 1]
                right = nums[i + 1] - nums[i]
                if left <= right:
                    closest[i] = i - 1
                else:
                    closest[i] = i + 1
        
        
        pref = [0] * n
        for i in range(1, n):
            if closest[i - 1] == i:
                pref[i] = pref[i - 1] + 1
            else:
                pref[i] = pref[i - 1] + (nums[i] - nums[i - 1])
        
        
        suff = [0] * n
        for i in range(n - 2, -1, -1):
            if closest[i + 1] == i:
                suff[i] = suff[i + 1] + 1
            else:
                suff[i] = suff[i + 1] + (nums[i + 1] - nums[i])
        
        
        ans = []
        for l, r in queries:
            if l < r:
                ans.append(pref[r] - pref[l])
            else:
                ans.append(suff[r] - suff[l])
        
        return ans©leetcode
