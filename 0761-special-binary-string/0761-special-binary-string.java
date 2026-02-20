class Solution {
    public String makeLargestSpecial(String s) {
        // Base case 
        if (s.length() <= 2) return s; 
        List<String> subs = new ArrayList<>();
        int count = 0, start = 0; 
        // Split into special substrings 
        for (int i = 0; i < s.length(); i++) { 
            if (s.charAt(i) == '1') count++; 
            else count--; 
            if (count == 0) { 
                // Recursively solve inner substring 
                String inner = s.substring(start + 1, i); 
                subs.add("1" + makeLargestSpecial(inner) + "0"); 
                start = i + 1; 
                }
                } // Sort in descending order
                Collections.sort(subs, Collections.reverseOrder()); 
                // Concatenate 
                StringBuilder sb = new StringBuilder(); 
                for (String sub : subs) sb.append(sub); 
                return sb.toString();
    }
}