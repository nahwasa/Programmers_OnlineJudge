/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private int getNum(long idx, int n) {
        long r = idx / n;
        long c = idx % n;
        return (int)((r>c?r:c)+1);
    }
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        for (long i = left; i <= right; i++) {
            answer[(int)(i-left)] = getNum(i, n);
        }
        return answer;
    }
}
