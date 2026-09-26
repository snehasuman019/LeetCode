import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Build map from knowledge
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        // Step 2: Parse string
        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                insideBracket = true;
                key.setLength(0); // reset key
            } else if (c == ')') {
                insideBracket = false;
                // lookup key
                String value = map.getOrDefault(key.toString(), "?");
                result.append(value);
            } else {
                if (insideBracket) {
                    key.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
