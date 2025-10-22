class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0)
        return Collections.emptyList();
        List<String> res = new ArrayList<>();
        int start = 0, end = 1;
        while(end < nums.length){
            while(end < nums.length && nums[end - 1] == nums[end]-1)
            end++;
            if(start == end-1){
             res.add(nums[start] + "");
            }
            else{
                res.add(nums[start] + "->" + nums[end-1]);
            }
            if(end < nums.length)
            start = end;
            end++;
        }
        if(start == end-1){
            res.add(nums[start] + "");
        }
        return res;
    }
}