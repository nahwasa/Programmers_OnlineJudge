/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private static final String BASE = "ACFJMNRT";
    private int cnt, v;
    private String[] data;

    private boolean isConditionSatisfied(char[] arr) {
        for (String tmp : data) {
            char a = tmp.charAt(0);
            char b = tmp.charAt(2);
            int aIdx = 0, bIdx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == a)    aIdx = i;
                if (arr[i] == b)    bIdx = i;
            }

            int gap = Math.abs(aIdx - bIdx) - 1;
            int dataGap = tmp.charAt(4) - '0';
            switch (tmp.charAt(3)) {
                case '=' : if (gap != dataGap)  return false;   break;
                case '<' : if (gap >= dataGap)  return false;   break;
                case '>' : if (gap <= dataGap)  return false;   break;
            }
        }
        return true;
    }

    private void chkAllCase(int idx, char[] arr) {
        if (idx == BASE.length()){
            if (isConditionSatisfied(arr))
                cnt++;
            return;
        }
        for (int i = 0 ; i < BASE.length(); i++) {
            if ((v & 1<<i) != 0)    continue;   // already used
            v |= 1<<i;
            arr[idx] = BASE.charAt(i);
            chkAllCase(idx+1, arr);
            v ^= 1<<i;
        }
    }

    public int solution(int n, String[] data) {
        this.data = data;
        chkAllCase(0, new char[BASE.length()]);
        return cnt;
    }
}
