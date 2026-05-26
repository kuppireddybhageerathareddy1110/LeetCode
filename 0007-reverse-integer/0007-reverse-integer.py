class Solution:
    def reverse(self, x: int) -> int:

        sign = -1 if x < 0 else 1
        x = abs(x)

        rev = 0

        while x != 0:
            digit = x % 10
            x //= 10

            # Overflow check before update
            if rev > (2**31 - 1) // 10:
                return 0

            rev = rev * 10 + digit

        rev *= sign

        # Final range check
        if -2**31 <= rev <= 2**31 - 1:
            return rev

        return 0