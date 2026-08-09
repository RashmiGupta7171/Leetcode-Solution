class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        
        // Store elements of nums1
        for (int num : nums1) {
            set1.add(num);
        }
        
        HashSet<Integer> result = new HashSet<>();
        
        // Check which elements of nums2 are present in nums1
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        
        // Convert HashSet to int[]
        int[] answer = new int[result.size()];
        int i = 0;
        
        for (int num : result) {
            answer[i++] = num;
        }
        
        return answer;
    }
}