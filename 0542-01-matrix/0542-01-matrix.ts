function updateMatrix(mat: number[][]): number[][] {
    const rows=mat.length;
    const cols=mat[0].length;
    const queue:[number,number][]=[];
    const dist:number[][]=Array.from(
        {length:rows},
        ()=>Array(cols).fill(-1)
    );

    //Initialize queue with all 0s
    for(let r=0;r<rows;r++){
        for(let c=0;c<cols;c++){
            if(mat[r][c]===0){
                queue.push([r,c]);
                dist[r][c]=0;
            }
        }
    }
    const directions=[
        [1,0],
        [-1,0],
        [0,1],
        [0,-1]    ];

    let front=0;
    while(front<queue.length){
        const [r,c]=queue[front++];
        for(const [dr,dc] of directions){
            const nr=r+dr;
            const nc=c+dc;
            if(nr>=0&&nr<rows&&nc>=0&&nc<cols&&dist[nr][nc]===-1){
                dist[nr][nc]=dist[r][c]+1;
                queue.push([nr,nc]);
            }
        }
    }

return dist;


};