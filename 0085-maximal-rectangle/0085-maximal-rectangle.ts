function maximalRectangle(matrix: string[][]): number {
const rows=matrix.length;
const cols=matrix[0].length;
const heights=new Array<number>(cols).fill(0);
let maxArea=0;
for(let i=0;i<rows;i++){
    for(let j=0;j<cols;j++){
        heights[j]=matrix[i][j]==='1'?heights[j]+1:0;

    }
    const stack:number[]=[];
    for(let j=0;j<=cols;j++){
        const currHeight=(j===cols)?0:heights[j];
        while(stack.length&&heights[stack[stack.length-1]]>=currHeight){
            const h=heights[stack.pop()!];
            const width=stack.length===0?j:j-stack[stack.length-1]-1;
            maxArea=Math.max(maxArea,h*width);
        }
        stack.push(j);
    }
}
return maxArea;

    
};