from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        rows=len(matrix)
        cols=len(matrix[0])
        heights=[0]*cols
        max_area=0

        for i in range(rows):
            for j in range(cols):
                if matrix[i][j]=='1':
                    heights[j]+=1
                else:
                    heights[j]=0
            stack=[]

            for j in range(cols+1):
                curr_height=0 if j==cols else heights[j]
                while stack and heights[stack[-1]]>=curr_height:
                    h=heights[stack.pop()]
                    width=(j if not stack else j-stack[-1]-1)
                    max_area=max(max_area,h*width)
                stack.append(j)

        return max_area

            
        