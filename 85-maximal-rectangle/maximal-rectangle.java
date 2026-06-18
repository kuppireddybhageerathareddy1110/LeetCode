class Solution {
    public int maximalRectangle(char[][] matrix) {

        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] heights=new int[cols];
        int maxArea=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }


            }
            int[] stack=new int[cols+1];
            int top=-1;
            for(int j=0;j<=cols;j++){
                int currHeight=(j==cols)?0:heights[j];
                while(top>=0&& heights[stack[top]]>=currHeight){
                    int h=heights[stack[top--]];
                    int width=(top<0)?j:j-stack[top]-1;
                    maxArea=Math.max(maxArea,h*width);
                }
                stack[++top]=j;
            }
        }
        
        return maxArea;
    }
}