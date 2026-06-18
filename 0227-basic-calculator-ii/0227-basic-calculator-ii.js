/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {

    const stack = [];
    let num = 0;
    let op = '+';

    for (let i = 0; i <= s.length; i++) {

        const ch = (i === s.length) ? '+' : s[i];

        if (ch >= '0' && ch <= '9') {
            num = num * 10 + (ch.charCodeAt(0) - 48);
        }

        if (
            i === s.length ||
            ch === '+' ||
            ch === '-' ||
            ch === '*' ||
            ch === '/'
        ) {

            if (op === '+') {
                stack.push(num);
            } 
            else if (op === '-') {
                stack.push(-num);
            } 
            else if (op === '*') {
                stack.push(stack.pop() * num);
            } 
            else if (op === '/') {
                stack.push(Math.trunc(stack.pop() / num));
            }

            op = ch;
            num = 0;
        }
    }

    let ans = 0;

    for (const x of stack) {
        ans += x;
    }

    return ans;
};