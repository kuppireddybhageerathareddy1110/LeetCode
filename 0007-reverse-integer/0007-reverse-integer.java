// class Solution {
//     public int reverse(int x) {

//         int rev = 0;

//         while (x != 0) {

//             int digit = x % 10;
//             x /= 10;
//             int y=(int)Math.pow(2,31)/10;
//             // Check overflow using constraints
//             if (rev > y ||
//                rev < -y) {
//                 return 0;
//             }

//             rev = rev * 10 + digit;
//         }

//         return rev;
//     }
// }


class Solution {
    public int reverse(int x) {

        int rev = 0;

        while (x != 0) {

            int digit = x % 10; // get last digit
            x = x / 10;         // remove last digit

            // Overflow check
            if (rev > Integer.MAX_VALUE / 10 || 
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Underflow check
            if (rev < Integer.MIN_VALUE / 10 || 
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}