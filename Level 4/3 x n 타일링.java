import java.util.function.Function;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    Function<Integer, Boolean> isOdd = (n) -> (n&1)==1;

    public int solution(int n) {
        if (isOdd.apply(n)) return 0;
        long[] dp = new long[n/2];
        dp[0] = 3;
        dp[1] = 11;
        long tmp = 0l;
        for (int i = 2; i < n/2; i++) {
            dp[i] = dp[i-1] * 3 + 2 + (tmp+=dp[i-2]*2);
            dp[i] %= 1000000007;
        }
        return (int) dp[n/2-1];
    }
}
