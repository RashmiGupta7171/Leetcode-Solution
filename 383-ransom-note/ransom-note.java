class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        // Count letters in magazine
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // Use letters for ransomNote
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']--;

            // Not enough letters available
            if (count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}