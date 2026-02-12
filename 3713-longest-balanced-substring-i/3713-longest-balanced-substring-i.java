class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen = 0;
        for(int i=0;i<n;i++){
            int freq[] = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if((j-i+1)>maxlen && checkBalance(freq)){
                    maxlen=j-i+1;
                }

            }
        }
        return maxlen;
    }
        boolean checkBalance(int freq[]){
            int except = 0;
            for(int f : freq){
                if(f==0)
                    continue;
                if(except==0)
                    except = f;
                else if(f!=except)
                    return false;
            }
            return true;
        }
    }
