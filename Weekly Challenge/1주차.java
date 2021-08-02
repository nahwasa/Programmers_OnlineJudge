class Solution {
    public long solution(int price, int money, int count) {
        long answer = money - (long)price * (count+1) * count / 2;
        return answer < 0 ? -answer : 0;
    }
}
