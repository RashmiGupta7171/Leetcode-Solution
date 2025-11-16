
        class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = getNext(res);
        }
        return res;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;  // count of current character
        
        for (int i = 1; i < s.length(); i++) {
            // If current char matches previous one, increase count
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // Otherwise, append count and previous char
                sb.append(count).append(s.charAt(i - 1));
                count = 1; // reset count
            }
        }
        
        // Append the last run
        sb.append(count).append(s.charAt(s.length() - 1));
        
        return sb.toString();
    }
}

