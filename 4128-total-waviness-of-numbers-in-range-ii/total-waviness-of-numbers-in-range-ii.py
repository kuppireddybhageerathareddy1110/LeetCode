class Solution:
    waves = []

    # Precompute all valid 3-digit wave patterns
    for i in range(1000):
        right = i % 10
        mid = (i // 10) % 10
        left = (i // 100) % 10

        if (mid > left and mid > right) or \
           (mid < left and mid < right):
            waves.append(i)

    def totalWaviness(self, num1: int, num2: int) -> int:
        return self.count(num2) - self.count(num1 - 1)

    def count(self, num: int) -> int:
        if num < 100:
            return 0

        total = 0

        for pattern in self.waves:
            total += self.count_pattern(num, pattern)

        return total

    def count_pattern(self, num: int, pattern: int) -> int:
        count = 0
        multiplier = 1

        # Handle leading zero cases
        pattern_type = 1 if pattern < 100 else 0

        while multiplier * 100 <= num:

            prefix = num // (multiplier * 1000)
            current = (num // multiplier) % 1000
            suffix = num % multiplier

            if current > pattern:
                ways = prefix - pattern_type + 1
            elif current == pattern:
                ways = max(0, prefix - pattern_type)
                count += suffix + 1
            else:
                ways = max(0, prefix - pattern_type)

            count += ways * multiplier
            multiplier *= 10

        return count