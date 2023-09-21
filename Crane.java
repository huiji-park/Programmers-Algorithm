import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0) {
                    int toy = board[j][moves[i] - 1];
                    board[j][moves[i] - 1] = 0;
                    if(!stack.isEmpty() && stack.peek() == toy) {
                        stack.pop();
                        answer += 2;
                        break;
                    }
                    else {
                        stack.push(toy);
                        break;
                    }
                }
            }
        }

        return answer;
    }
}