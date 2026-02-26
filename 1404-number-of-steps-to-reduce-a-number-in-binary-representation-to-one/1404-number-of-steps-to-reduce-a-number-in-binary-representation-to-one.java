class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry =0;
        int n = s.length();
        for(int i =n-1; i>0; i--){
            int bit = s.charAt(i) - '0' + carry;
            if(bit % 2 == 0){
                steps++;
            }else{
                steps += 2;
                carry = 1;
            }
        }
        return steps + carry;
    }
}