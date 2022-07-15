-- 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
class Solution {
    private static final int GAP = 'z'-'Z';
    public String solution(String s) {
        char[] arr = s.toUpperCase().toCharArray();
        int chk = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == ' ') {
                chk = 0;
                continue;
            }
            if ((chk++&1)==1)
                arr[i]+=GAP;
        }
        return String.valueOf(arr);
    }
}
