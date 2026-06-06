class Solution:
    def longestPalindrome(self, s: str) -> str:
        n=len(s)
        if n==0:
            return ""
        start=0
        max_len=1
        def expand(left,right):
            while left>=0 and right<n and s[left]==s[right]:
                left-=1
                right+=1

            return left+1,right-1

        for i in range(n):
            l1,r1=expand(i,i)
            len1=r1-l1+1
            if len1>max_len:
                start=l1
                max_len=len1
            l2,r2=expand(i,i+1)
            len2=r2-l2+1
            if len2>max_len:
                start=l2
                max_len=len2
        return s[start:start+max_len]


