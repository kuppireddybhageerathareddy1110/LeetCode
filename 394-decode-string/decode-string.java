class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int currNum = 0;
        String currStr = "";

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }

            else if (ch == '[') {

                countStack.push(currNum);
                stringStack.push(currStr);

                currNum = 0;
                currStr = "";
            }

            else if (ch == ']') {

                int repeat = countStack.pop();
                String prevStr = stringStack.pop();

                StringBuilder sb = new StringBuilder(prevStr);

                for (int i = 0; i < repeat; i++) {
                    sb.append(currStr);
                }

                currStr = sb.toString();
            }

            else {
                currStr += ch;
            }
        }

        return currStr;
    }
}