class Solution:
    def calculate(self, s: str) -> int:
        stack=[]
        num=0
        op='+'
        for i in range(len(s)+1):
            ch='+' if i==len(s) else s[i]

            if ch.isdigit():
                num=num*10+int(ch)
            if i==len(s) or ch in '+-*/':
                if op=='+':
                    stack.append(num)
                elif op=='-':
                    stack.append(-num)
                elif op=='*':
                    stack.append(stack.pop()*num)

                elif op=='/':
                    stack.append(int(stack.pop()/num))
                op=ch
                num=0

        return sum(stack)
        