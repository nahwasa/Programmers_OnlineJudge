/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private int[] order = {-1, 1};
    public int solution(int n, int[] lost, int[] reserve) {
        n-=lost.length;
        int[] lostNum = new int[31];
        for (int i = 0; i < lost.length; i++) lostNum[lost[i]] = 1;
        int[] chk = new int[32];
        for (int i = 0; i < reserve.length; i++) chk[reserve[i]] = 1;
        for (int i = 0; i < 31; i++) if (lostNum[i]*chk[i]==1) {n++; lostNum[i]=chk[i]=0;}
        for (int i = 0; i < 31; i++) {
            if (lostNum[i]!=1) continue;
            for (int j = 0; j < 2; j++) {
                if (chk[i+order[j]]==1) {
                    chk[i+order[j]]--;
                    n++;
                    break;
                }
            }
        }
        return n;
    }
}
