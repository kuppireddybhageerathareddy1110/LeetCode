class Solution {
    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int digit = x % 10;
            x /= 10;

            // Check overflow using constraints
            if (rev > (int)Math.pow(2, 31) / 10 ||
               rev < -(int)Math.pow(2, 31) / 10) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}