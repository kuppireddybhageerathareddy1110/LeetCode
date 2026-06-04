/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
var totalWaviness = function(num1, num2) {
    let total = 0;

    for (let num = num1; num <= num2; num++) {
        const s = num.toString();

        // Numbers with fewer than 3 digits
        if (s.length < 3) continue;

        for (let i = 1; i < s.length - 1; i++) {
            // Peak
            if (s[i] > s[i - 1] && s[i] > s[i + 1]) {
                total++;
            }
            // Valley
            else if (s[i] < s[i - 1] && s[i] < s[i + 1]) {
                total++;
            }
        }
    }

    return total;
};