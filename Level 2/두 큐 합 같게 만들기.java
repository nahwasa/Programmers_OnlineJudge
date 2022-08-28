import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1=0, s2=0, sum;
        for (int tmp : queue1) {q1.add(tmp); s1+=tmp;}
        for (int tmp : queue2) {q2.add(tmp); s2+=tmp;}
        sum = s1+s2;
        if (sum%2==1) return -1;
        sum/=2;
        int p1 = 0, p2 = 0, limit = queue1.length*2;
        while (p1<=limit && p2<=limit) {
            if (s1 == sum) return p1+p2;
            if (s1>sum) {
                s1-=q1.peek();
                s2+=q1.peek();
                q2.add(q1.poll());
                p1++;
            } else {
                s2-=q2.peek();
                s1+=q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }
}
