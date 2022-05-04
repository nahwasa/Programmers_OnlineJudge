/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    class Document{
        int priority;
        boolean isTarget;
        public Document(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }
    }

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
        Deque<Document> dq = new ArrayDeque<>();
        int[] cnt = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            cnt[priorities[i]]++;
            dq.addLast(new Document(priorities[i], i==location));
        }
        int answer = 0;
        while (!dq.isEmpty()) {
            Document cur = dq.pollFirst();
            int maxPriority = getMaxPriority(cnt);
            if (cur.priority != maxPriority) {
                dq.addLast(cur);
                continue;
            }
            answer++;
            if (cur.isTarget)
                break;
            if (--cnt[cur.priority] == 0)
                max = -1;
        }

        return answer;
    }
}
