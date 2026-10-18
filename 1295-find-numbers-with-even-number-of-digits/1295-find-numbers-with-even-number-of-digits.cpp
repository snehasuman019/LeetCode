class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int count = 0;
        for (int i =0; i<nums.size();i++){
            int num = nums[i];
            int digits=0;
            for(;num>0;num /=10){
                digits++;
            }
        if(digits % 2 ==0){
            // cout<<nums[i]<<" ";
            count++;
        }
    }
    return count;
    }
};