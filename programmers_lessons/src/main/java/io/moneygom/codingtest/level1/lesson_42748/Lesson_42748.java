package io.moneygom.codingtest.level1.lesson_42748;

import java.util.Arrays;

public class Lesson_42748 {
    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        Solution solution = new Solution();
        int[] results = solution.solution(array, commands);
        for (int i=0; i<results.length; i++) {
            System.out.println(results[i]);
        }
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // commands의 1차 배열의 수만큼 명령을 반복 요청하고 결과값을 answer에 차례로 담는다.
        for (int i=0; i < commands.length; i++) {
            answer[i] = find(array, commands[i]);
        }

        return answer;
    }

    private int find(int[] array, int[] command) {
        int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
        Arrays.sort(temp);
        return temp[command[2]-1];
    }
}
