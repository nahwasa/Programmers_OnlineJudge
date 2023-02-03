/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String cur : skill_trees) {
            cur = cur.replaceAll("[^"+skill+"]", "");
            answer += skill.indexOf(cur)==0 ? 1 : 0;
        }
        return answer;
    }
}
