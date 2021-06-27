import java.util.*;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private Map<Character, Integer> openMap, closeMap;

    private boolean isValid(List<Character> list) {
        Stack<Integer> stk = new Stack<>();
        Iterator<Character> it = list.iterator();
        while(it.hasNext()) {
            char c = it.next();

            if (openMap.containsKey(c)) {
                stk.push(openMap.get(c));
                continue;
            }

            if (stk.isEmpty())
                return false;

            int tmp = stk.pop();
            if (tmp != closeMap.get(c))
                return false;
        }
        return stk.isEmpty() ? true : false;
    }

    private void initMap() {
        openMap = new HashMap<>();
        openMap.put('[', 0);
        openMap.put('(', 1);
        openMap.put('{', 2);

        closeMap = new HashMap<>();
        closeMap.put(']', 0);
        closeMap.put(')', 1);
        closeMap.put('}', 2);
    }

    public int solution(String s) {
        initMap();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        int answer = 0;
        int rotateCnt = s.length() - 1;
        while (rotateCnt-->0) {
            if (isValid(list))
                answer++;
            list.addLast(list.pollFirst());
        }

        return answer;
    }
}
