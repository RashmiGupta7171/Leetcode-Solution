class Solution {
    public int binaryGap(int n) {
        int lastPos = -1;
        int maxDistance = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) { 
                if (lastPos != -1) {
                    maxDistance = Math.max(maxDistance, position - lastPos);
                }
                lastPos = position;
            }
            n >>= 1;
            position++;
        }

        return maxDistance;
    }
}