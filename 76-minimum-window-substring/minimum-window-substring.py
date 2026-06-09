class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m,n=len(s),len(t)
        if n>m:
            return ""
        freq=[0]*128
        for ch in t:
            freq[ord(ch)]+=1
        left=0
        count=0
        min_len=float('inf')
        start_index=-1
        for right in range(m):
            ch=s[right]
            if freq[ord(ch)]>0:
                count+=1
            freq[ord(ch)]-=1
            while count==n:
                window_len=right-left+1
                if window_len<min_len:
                    min_len=window_len
                    start_index=left
                left_char=s[left]
                freq[ord(left_char)]+=1
                if freq[ord(left_char)]>0:
                    count-=1
                left+=1
        return "" if start_index==-1 else s[start_index:start_index+min_len]