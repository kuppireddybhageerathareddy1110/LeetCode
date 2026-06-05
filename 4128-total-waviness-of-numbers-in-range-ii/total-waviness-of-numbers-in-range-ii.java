class Solution {

    static final int[] waves = new int[570];

    static {
        int idx = 0;

        for (int i = 0; i < 1000; i++) {
            int right = i % 10;
            int mid = (i / 10) % 10;
            int left = (i / 100) % 10;

            // Peak or Valley
            if ((mid > left && mid > right) ||
                (mid < left && mid < right)) {
                waves[idx++] = i;
            }
        }
    }

    public long totalWaviness(long num1, long num2) {
        return count(num2) - count(num1 - 1);
    }

    private long count(long num) {
        if (num < 100) return 0;

        long total = 0;

        for (int pattern : waves) {
            total += countPattern(num, pattern);
        }

        return total;
    }

    private long countPattern(long num, int pattern) {

        long count = 0;
        long multiplier = 1;

        // Handle leading zero cases
        long type = (pattern < 100) ? 1 : 0;

        while (multiplier * 100 <= num) {

            long prefix = num / (multiplier * 1000);
            long current = (num / multiplier) % 1000;
            long suffix = num % multiplier;

            long ways;

            if (current > pattern) {
                ways = prefix - type + 1;
            } else if (current == pattern) {
                ways = Math.max(0L, prefix - type);
                count += suffix + 1;
            } else {
                ways = Math.max(0L, prefix - type);
            }

            count += ways * multiplier;
            multiplier *= 10;
        }

        return count;
    }
}