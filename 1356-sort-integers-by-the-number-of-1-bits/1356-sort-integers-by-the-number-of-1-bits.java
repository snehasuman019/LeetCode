import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert array to list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        // Custom sort
        Collections.sort(list, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            if (bitA == bitB) {
                return a - b; // sort by value
            } else {
                return bitA - bitB; // sort by bit count
            }
        });
        // Convert back to array
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
