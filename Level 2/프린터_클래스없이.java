/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    private static int max = -1;
    private int getMaxPriority(int[] cnt) {
        if (max == -1) {
            for (int i = 9; i >= 1; i--) {
                if (cnt[i] != 0) {
                    max = i;
                    return max;
                }
            }
        }
        return max;
    }

    public int solution(int[] priorities, int location) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] cnt = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            cnt[priorities[i]]++;
            dq.addLast(priorities[i]);
        }
        int answer = 0;
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            int maxPriority = getMaxPriority(cnt);
            if (cur != maxPriority) {
                dq.addLast(cur);
            } else {
                answer++;
                if (location == 0)
                    break;
                if (--cnt[cur] == 0)
                    max = -1;
            }
            if (--location == -1)
                location = dq.size()-1;
        }

        return answer;
    }
}
