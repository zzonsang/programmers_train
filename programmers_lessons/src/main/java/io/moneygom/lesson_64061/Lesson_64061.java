package io.moneygom.lesson_64061;

import java.util.ArrayList;
import java.util.List;

public class Lesson_64061 {
    public static void main( String[] args ) {
        
        // int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        // int[] moves = {1,5,3,5,1,2,1,4};

        int[][] board = {{0,0,0,0,0},{0,0,0,0,1},{0,0,0,0,1}};
        int[] moves = {5,5};

        Solution solution = new Solution();
        System.out.println(solution.solution(board, moves));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 터진 갯수 결과값
        int answer = 0;

        List<Integer> tempList = new ArrayList<Integer>();

        int lastNum = 0;
        for (int i = 0; i < moves.length; i++) {
            int pickLine = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                int pickNum = board[j][pickLine];
                if (pickNum != 0) {
                    board[j][pickLine] = 0;
                    if (pickNum == lastNum) {
                        tempList.remove(tempList.size()-1);
                        lastNum = tempList.size() > 0 ? tempList.get(tempList.size()-1) : 0;
                        answer += 2;
                    } else {
                        lastNum = pickNum;
                        tempList.add(pickNum);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
