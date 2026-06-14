class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        n = len(temperatures)

        # Result array initialized with 0
        answer = [0] * n

        """
        Example:
        temperatures = [73,74,75,71,69,72,76,73]

        answer = [0,0,0,0,0,0,0,0]
        """

        # Start from second last element
        # because last day has no future warmer day
        for i in range(n - 2, -1, -1):

            # start checking next day
            j = i + 1

            """
            Example:
            i = 5
            temperature = 72

            j = 6
            temperature = 76
            """

            # search until warmer day found
            while j < n and temperatures[j] <= temperatures[i]:

                """
                if future temperature
                is not warmer
                """

                # no warmer day exists
                if answer[j] == 0:
                    j = n

                    """
                    stop searching
                    """

                else:
                    # jump directly
                    j += answer[j]

                    """
                    Instead of checking:
                    j+1, j+2, j+3

                    directly jump
                    using previous answer
                    """

            # warmer day found
            if j < n:
                answer[i] = j - i

                """
                Example:
                i = 3 (71)
                j = 5 (72)

                answer[3] = 2
                """

        return answer