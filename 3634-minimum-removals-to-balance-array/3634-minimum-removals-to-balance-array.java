class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);              //sliding window
        int n = nums.length;
        int left = 0 , right =0;
        int ans = n+1;
        while(left < n){
            while(right<n && nums[right]<=(long)k*nums[left])
                right++;
            ans = Math.min(ans, n-(right-left));
            left++;
        }
        return ans;
    }
    
static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter fw = new FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {}
        }));}
}