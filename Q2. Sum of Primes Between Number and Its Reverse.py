class Solution:
    def sumOfPrimesInRange(self, n: int) -> int:
        mavroliken = n
        
        r = int(str(n)[::-1])
        
        low = min(n, r)
        high = max(n, r)
        
        def is_prime(x):
            if x < 2:
                return False
            for i in range(2, int(x**0.5) + 1):
                if x % i == 0:
                    return False
            return True
        
        ans = 0
        for num in range(low, high + 1):
            if is_prime(num):
                ans += num
        
        return ans©leetcode
