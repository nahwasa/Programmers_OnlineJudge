import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : participant) {
            if (!hm.containsKey(s))
                hm.put(s, 0);
            hm.put(s, hm.get(s) + 1);
        }

        for (String s : completion) {
            hm.put(s, hm.get(s) - 1);
            if (hm.get(s) == 0)
                hm.remove(s);
        }

        return hm.keySet().iterator().next();
    }
}
