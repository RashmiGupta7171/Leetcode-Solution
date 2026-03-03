

class Solution {
    public String largestNumber(int[] nums) {
        
        // Convert integers to strings
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // If the largest element is "0", return "0"
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // Build result
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}