package io.moneygom.lesson_42576;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson_42576 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution solution = new Solution();
        System.out.println(solution.solutionHash(participant, completion));
    }
}

class Solution {
    // 배열로 비교
    public String solution(String[] participant, String[] completion) {
        // 오름차순으로 이름을 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 각 배열을 비교하여 다른 값이 나오는 Participant 배열의 문자열이 정답
        // 단, 비교 대상이 없는 Participant의 마지막 배열까지 갔다면 마지막 값이 정답
        for(int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        
        // 끝까지 찾지 못한 마지막 이름
        return participant[participant.length-1];
    } 

    // HashMap에 담아서 결과값이 1보다 큰 값으로 찾기
    public String solutionHash(String[] participant, String[] completion) {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        generateMap(resultMap, participant, true);
        generateMap(resultMap, completion, false);

        for (String key : resultMap.keySet()) {
            if (resultMap.get(key) != 0) {
                return key;
            }
        }

        return "Not Found";
    }

    public Map<String, Integer> generateMap(Map<String, Integer> map, String[] arrays, boolean plus) {
        int convert = plus ? 1 : -1;
        for (String value : arrays) {
            map.put(value, map.getOrDefault(value, 0) + convert);
        }
        return map;
    }
}