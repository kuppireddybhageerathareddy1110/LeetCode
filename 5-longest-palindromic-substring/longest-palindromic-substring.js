/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let n = s.length;

    if (n === 0) {
        return "";
    }

    let start = 0;
    let maxLen = 1;

    function expand(left, right) {
        while (
            left >= 0 &&
            right < n &&
            s[left] === s[right]
        ) {
            left--;
            right++;
        }

        return [left + 1, right - 1];
    }

    for (let i = 0; i < n; i++) {

        // Odd length palindrome
        let [l1, r1] = expand(i, i);
        let len1 = r1 - l1 + 1;

        if (len1 > maxLen) {
            start = l1;
            maxLen = len1;
        }

        // Even length palindrome
        let [l2, r2] = expand(i, i + 1);
        let len2 = r2 - l2 + 1;

        if (len2 > maxLen) {
            start = l2;
            maxLen = len2;
        }
    }

    return s.substring(start, start + maxLen);
};