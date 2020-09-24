package com.company;

import java.util.Stack;

public class BalPar {

    private Stack stack = new Stack();

    // min implementering.
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

    // Ole Dolris implementering.
    public boolean balpar(String text){
        for(int i = 0; i < text.length();i++){
            if(text.charAt(i) == '('){
                stack.push(text.charAt(i));
            }
            if(text.charAt(i)==')'){
                if(stack.empty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

}
