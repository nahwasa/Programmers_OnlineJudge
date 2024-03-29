/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = numer1*denom2 + denom1*numer2;
        int denom = denom1*denom2;
        
        int limit = (int) Math.sqrt(Math.max(numer, denom))+1;
        for (int i = 2; i <= limit; i++) {
            while (numer%i == 0 && denom%i == 0) {
                numer /= i;
                denom /= i;
            }
        }
        return new int[]{numer, denom};
    }
}
