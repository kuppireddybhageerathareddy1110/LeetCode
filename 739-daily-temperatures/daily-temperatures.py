class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n=len(temperatures)
        answer=[0]*n
        for i in range(n-2,-1,-1):
            j=i+1
            while j<n and temperatures[j]<=temperatures[i]:
                if answer[j]==0:
                    j=n
                else:
                    j+=answer[j]

            if j<n:
                answer[i]=j-i


        return answer
        