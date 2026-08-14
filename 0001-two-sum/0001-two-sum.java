class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int cm= target-nums[i];
            if(map.containsKey(cm)){
                return new int[] {map.get(cm),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};


        }
        
}
