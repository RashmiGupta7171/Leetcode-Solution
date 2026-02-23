
class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Total possible binary codes of length k
        int needed = 1 << k;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            if (!set.contains(sub)) {
                set.add(sub);
                needed--;
                if (needed == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}