class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        // result array
        int[] answer = new int[n];

        /*
        Example:
        temperatures = [73,74,75,71,69,72,76,73]

        answer = [0,0,0,0,0,0,0,0]
        */

        // start from second-last element
        // because last element can never have warmer future day
        for (int i = n - 2; i >= 0; i--) {

            // check next day
            int j = i + 1;

            /*
            Example:
            i = 5
            temp = 72

            j = 6
            temp = 76
            */

            // keep searching until warmer day found
            while (j < n && temperatures[j] <= temperatures[i]) {

                /*
                If future temp <= current temp,
                not warmer, so move forward
                */

                // no warmer temperature exists after j
                if (answer[j] == 0) {

                    j = n; // stop searching

                    /*
                    means:
                    no warmer temp exists ahead
                    */

                } else {

                    // jump ahead directly
                    j += answer[j];

                    /*
                    Example:

                    If answer[j] = 3

                    Instead of:
                    j+1, j+2, j+3

                    directly jump:
                    j = j + 3
                    */
                }
            }

            // warmer day found
            if (j < n) {
                answer[i] = j - i;

                /*
                Example:

                i = 3 (71)
                j = 5 (72)

                answer[3] = 5 - 3 = 2
                */
            }
        }

        return answer;
    }
}