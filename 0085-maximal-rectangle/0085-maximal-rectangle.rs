impl Solution {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {

        let rows=matrix.len();
        let cols=matrix[0].len();
        let mut heights=vec![0;cols];
        let mut max_area=0;
        for i in 0..rows{
            for j in 0..cols{
                if matrix[i][j]=='1'{
                    heights[j]+=1;
                }else{
                    heights[j]=0;
                }
            }

            let mut stack:Vec<usize>=Vec::new();
            for j in 0..=cols{
                let curr_height=if j==cols{
                    0
                }else{
                    heights[j]
                };
                while !stack.is_empty() && heights[*stack.last().unwrap()]>=curr_height{
                    let h=heights[stack.pop().unwrap()];
                    let width=if stack.is_empty(){
                        j
                    }else{
                        j-stack.last().unwrap()-1
                    };
                    max_area=max_area.max(h*width as i32);
                }
                stack.push(j);
            }

        }    
        max_area   
    }
}