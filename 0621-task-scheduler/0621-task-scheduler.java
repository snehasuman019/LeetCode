import java.util.*;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks){
            freq[t - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int countMax = 1;
        for(int i = 24; i >= 0; i--){
            if(freq[i] == maxFreq) countMax++;
            else break;
        }
        int partCount = maxFreq - 1;
        int partLength = n - (countMax - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * countMax;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }
}
