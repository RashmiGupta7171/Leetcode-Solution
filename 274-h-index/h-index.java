class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        
        // Sort the array
        Arrays.sort(citations);
        
        // Traverse and find h-index
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}