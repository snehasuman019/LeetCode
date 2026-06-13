class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            // Calculate weight of the word
            for (char c : word.toCharArray()) {
                int index = c - 'a';   // position in alphabet
                sum += weights[index]; // add corresponding weight
            }

            // Modulo 26
            int mod = sum % 26;

            // Reverse alphabetical mapping
            char mappedChar = (char) ('z' - mod);

            result.append(mappedChar);
        }

        return result.toString();
    }
}
