/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    const countStack=[];
    const stringStack=[];

    let currNum=0;
    let currStr="";

    for(const ch of s){
        if(ch>='0' && ch<='9'){
            currNum=currNum*10+Number(ch);
        }
        else if(ch==='['){
            countStack.push(currNum);
            stringStack.push(currStr);
            currNum=0;
            currStr="";
        }
        else if(ch===']'){
            const repeat=countStack.pop();
            const prevStr=stringStack.pop();
            currStr=prevStr+currStr.repeat(repeat);
        }
        else{
            currStr+=ch;
        }
    }

    return currStr;





};