class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int num=0;
        char op='+';
        for(int i=0;i<=s.length();i++){
            char ch=(i==s.length())?'+':s.charAt(i);

            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }

            if(i==s.length()||ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                if(op=='+'){
                    stack.push(num);
                }else if(op=='-'){
                    stack.push(-num);
                }else if(op=='*'){
                    stack.push(stack.pop()*num);
                }else if(op=='/'){
                    stack.push(stack.pop()/num);
                }

                op=ch;
                num=0;
            }
            
            
            
            
                  }

                  int ans=0;
                  while(!stack.isEmpty()){
                    ans+=stack.pop();
                  }

                  return ans;
        





    }
}