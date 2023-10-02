import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        for(int i = 0; i < input.length; i++) {
            if(input[i] == ')') {
                if(stack.empty() || stack.pop() != '(')
                    return false;
            }
            else
                stack.push(input[i]);
        }
        return stack.empty();
    }
}