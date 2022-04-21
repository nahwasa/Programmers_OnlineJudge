/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] dpInclude0 = new int[len];
        int[] dpExclude0 = new int[len];
        dpInclude0[0] = dpInclude0[1] = money[0];
        dpExclude0[1] = money[1];

        for (int i = 2; i < len; i++) {
            dpInclude0[i] = Math.max(dpInclude0[i-1], money[i] + dpInclude0[i-2]);
            dpExclude0[i] = Math.max(dpExclude0[i-1], money[i] + dpExclude0[i-2]);
        }

        return Math.max(dpInclude0[len-2], dpExclude0[len-1]);
    }
}
