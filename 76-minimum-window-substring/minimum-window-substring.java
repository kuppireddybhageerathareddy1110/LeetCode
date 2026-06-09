class Solution {
    public String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (n > m) return "";

        // Frequency array for ASCII characters
        int[] freq = new int[128];

        // Count characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int count = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        // Expand window
        for (int right = 0; right < m; right++) {

            char ch = s.charAt(right);

            // Needed character found
            if (freq[ch] > 0) {
                count++;
            }

            freq[ch]--;

            // Valid window found
            while (count == n) {

                // Update minimum answer
                int windowLen = right - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                freq[leftChar]++;

                // Required character removed
                if (freq[leftChar] > 0) {
                    count--;
                }

                left++;
            }
        }

        return startIndex == -1
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}