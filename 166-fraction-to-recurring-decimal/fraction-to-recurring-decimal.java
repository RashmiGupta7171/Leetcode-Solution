class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is 0
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to prevent overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        result.append(num / den);

        long remainder = num % den;

        // If no fractional part
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            // If remainder seen before → repeating part found
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            // Store remainder position
            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}
