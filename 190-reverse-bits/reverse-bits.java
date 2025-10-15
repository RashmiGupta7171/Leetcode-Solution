class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        for ( int i=0; i<32; i++){
            reverse = (reverse << 1) | (n & 1); //shift left then add last bit
            n = n >> 1; // shift n right
        }
        return reverse;
      
    }
}