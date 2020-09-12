package com.company;

import java.util.Stack;

public class BalPar {

    private Stack stack = new Stack();

    public boolean isBalanced(String text)
    {
        for(int i = 0; i<text.length(); i++)
        {
            if(i == text.length() && !stack.empty() || text.charAt(i) == ')' && stack.empty()){
                return false;
            }
            if(text.charAt(i) == '(' ) {
                stack.push(text.charAt(i));
            } else {
                char popped = (char) stack.pop();
                if(popped != '('){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

}
