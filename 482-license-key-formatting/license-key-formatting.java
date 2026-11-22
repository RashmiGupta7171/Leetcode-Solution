
class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            // Skip existing dashes
            if (ch == '-') {
                continue;
            }

            // Insert dash after every k characters
            if (count == k) {
                result.append('-');
                count = 0;
            }

            // Convert character to uppercase
            result.append(Character.toUpperCase(ch));
            count++;
        }

        // Reverse the result
        return result.reverse().toString();
    }
}
