class Solution {
    public int[] twoSum(int[] nums, int target) {
        //revised , use space if time complexity is high
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        int req = 0;
        int i = 0;
        for(i=1;i<nums.length;i++){
            req = target - nums[i];
            if(map.containsKey(req)){
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{map.get(req),i};
    }
}