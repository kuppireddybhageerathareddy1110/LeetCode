/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
var totalWaviness = function(num1, num2) {

    const waves = [];

    // Precompute all valid 3-digit wave patterns
    for (let i = 0; i < 1000; i++) {
        const right = i % 10;
        const mid = Math.floor(i / 10) % 10;
        const left = Math.floor(i / 100);

        if ((mid > left && mid > right) ||
            (mid < left && mid < right)) {
            waves.push(i);
        }
    }

    function count(num) {
        if (num < 100) return 0;

        let total = 0;

        for (const pattern of waves) {
            total += countPattern(num, pattern);
        }

        return total;
    }

    function countPattern(num, pattern) {
        let count = 0;
        let multiplier = 1;

        // Handle leading zero cases
        const patternType = pattern < 100 ? 1 : 0;

        while (multiplier * 100 <= num) {

            const prefix = Math.floor(num / (multiplier * 1000));
            const current = Math.floor(num / multiplier) % 1000;
            const suffix = num % multiplier;

            let ways = 0;

            if (current > pattern) {
                ways = prefix - patternType + 1;
            } else if (current === pattern) {
                ways = Math.max(0, prefix - patternType);
                count += suffix + 1;
            } else {
                ways = Math.max(0, prefix - patternType);
            }

            count += ways * multiplier;
            multiplier *= 10;
        }

        return count;
    }

    return count(num2) - count(num1 - 1);
};