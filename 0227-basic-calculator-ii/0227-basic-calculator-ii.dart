class Solution {
  int calculate(String s) {

    List<int> stack = [];
    int num = 0;
    String op = '+';

    for (int i = 0; i <= s.length; i++) {

      String ch = (i == s.length) ? '+' : s[i];

      if (i < s.length &&
          ch.codeUnitAt(0) >= '0'.codeUnitAt(0) &&
          ch.codeUnitAt(0) <= '9'.codeUnitAt(0)) {

        num = num * 10 + int.parse(ch);
      }

      if (i == s.length ||
          ch == '+' ||
          ch == '-' ||
          ch == '*' ||
          ch == '/') {

        if (op == '+') {
          stack.add(num);
        } else if (op == '-') {
          stack.add(-num);
        } else if (op == '*') {
          stack.add(stack.removeLast() * num);
        } else if (op == '/') {
          stack.add((stack.removeLast() / num).truncate());
        }

        op = ch;
        num = 0;
      }
    }

    int ans = 0;
    for (int x in stack) {
      ans += x;
    }

    return ans;
  }
}