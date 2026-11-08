class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        if (n1 == 0) {
            return 0;
        }

        int s1Len = s1.length();
        int s2Len = s2.length();

        int[] count = new int[n1 + 1];
        int[] index = new int[n1 + 1];

        int j = 0; 
        int cnt = 0; 

        for (int i = 1; i <= n1; i++) {

            for (int k = 0; k < s1Len; k++) {

                if (s1.charAt(k) == s2.charAt(j)) {
                    j++;

                    if (j == s2Len) {
                        j = 0;
                        cnt++;
                    }
                }
            }

            count[i] = cnt;
            index[i] = j;

            for (int k = 0; k < i; k++) {

                if (index[k] == j) {

                    int preCount = count[k];
                    int inLoopCount = count[i] - count[k];

                    int remaining = n1 - k;
                    int loopLength = i - k;

                    int totalCount = preCount;

                    totalCount += (remaining / loopLength)
                                  * inLoopCount;

                    totalCount += count[k + remaining % loopLength]
                                  - count[k];

                    return totalCount / n2;
                }
            }
        }

        return count[n1] / n2;
    }
}