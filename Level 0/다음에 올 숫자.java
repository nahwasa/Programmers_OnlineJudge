/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private boolean isDngCha(int[] common) {
        return common[2]-common[1] == common[1]-common[0];
    }
    
    public int solution(int[] common) {
        int answer = 0;
        if (isDngCha(common)) {
            answer = common[common.length-1] + common[2]-common[1];
        } else {
            answer = common[common.length-1] * (common[2]/common[1]);
        }
        
        return answer;
    }
}
