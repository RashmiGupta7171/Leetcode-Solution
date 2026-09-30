class Solution {
    public boolean validUtf8(int[] data) {
        int remaining = 0;

        for (int num : data) {
            int byteVal = num & 0xFF;

            if (remaining == 0) {
                // Determine how many bytes this character uses
                if ((byteVal & 0b10000000) == 0) {
                    remaining = 0;          // 1-byte character
                } else if ((byteVal & 0b11100000) == 0b11000000) {
                    remaining = 1;          // 2-byte character
                } else if ((byteVal & 0b11110000) == 0b11100000) {
                    remaining = 2;          // 3-byte character
                } else if ((byteVal & 0b11111000) == 0b11110000) {
                    remaining = 3;          // 4-byte character
                } else {
                    return false;
                }
            } else {
                // Continuation byte must start with 10
                if ((byteVal & 0b11000000) != 0b10000000) {
                    return false;
                }
                remaining--;
            }
        }

        return remaining == 0;
    }
}