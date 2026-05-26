class Solution:
    def reverse(self, x: int) -> int:

        sign = -1 if x < 0 else 1
        x = abs(x)
        rev = 0
        
        while x > 0:
            digit = x % 10
            rev = rev * 10 + digit
            x = x // 10
        
        result = sign * rev
        
        INT_MIN = -2**31
        INT_MAX = 2**31 - 1

        if result < INT_MIN or result > INT_MAX:
            return 0
        
        return result