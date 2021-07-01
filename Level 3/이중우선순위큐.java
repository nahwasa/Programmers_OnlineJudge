import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String str : operations) {
            StringTokenizer st = new StringTokenizer(str);
            String op = st.nextToken();
            switch (op.charAt(0)) {
                case 'I' :
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.containsKey(num) ? map.get(num)+1 : 1);
                    break;
                case 'D' :
                    if (map.isEmpty()) break;
                    int key = st.nextToken().charAt(0) == '1' ? map.lastKey() : map.firstKey();
                    int curKeyCnt = map.get(key);
                    if (curKeyCnt - 1 == 0) map.remove(key);
                    else map.put(key, curKeyCnt - 1);
            }
        }
        if (map.isEmpty())  return new int[] {0, 0};
        return new int[] {map.lastKey(), map.firstKey()};
    }
}
