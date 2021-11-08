import java.util.HashMap;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String cur = clothes[i][1];
            if (!hm.containsKey(cur)) {
                hm.put(cur, 1);
            } else {
                hm.put(cur, hm.get(cur)+1);
            }
        }
        int answer = 1;
        for (String s : hm.keySet()) {
            answer *= (hm.get(s)+1);
        }
        return answer-1;
    }
}
