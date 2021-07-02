/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private static final int MOD = 1000000007;
    public int solution(int n) {
        int a = 0, b = 1, cur = 0;
        while (n-->0) {
            cur = a + b;
            cur %= MOD;
            a = b;
            b = cur;
        }
        return cur;
    }
}
