
class Solution {
    public String validIPAddress(String queryIP) {

        // Check IPv4
        if (queryIP.contains(".")) {
            String[] parts = queryIP.split("\\.", -1);

            if (parts.length != 4) {
                return "Neither";
            }

            for (String part : parts) {

                // Empty part or length greater than 3
                if (part.length() == 0 || part.length() > 3) {
                    return "Neither";
                }

                // Leading zeros are not allowed
                if (part.length() > 1 && part.charAt(0) == '0') {
                    return "Neither";
                }

                // Only digits are allowed
                for (char c : part.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        return "Neither";
                    }
                }

                // Check range 0 to 255
                int num = Integer.parseInt(part);

                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }

            return "IPv4";
        }

        // Check IPv6
        if (queryIP.contains(":")) {
            String[] parts = queryIP.split(":", -1);

            if (parts.length != 8) {
                return "Neither";
            }

            for (String part : parts) {

                // Each group must contain 1 to 4 characters
                if (part.length() == 0 || part.length() > 4) {
                    return "Neither";
                }

                // Only hexadecimal characters are allowed
                for (char c : part.toCharArray()) {
                    boolean isValid =
                        (c >= '0' && c <= '9') ||
                        (c >= 'a' && c <= 'f') ||
                        (c >= 'A' && c <= 'F');

                    if (!isValid) {
                        return "Neither";
                    }
                }
            }

            return "IPv6";
        }

        return "Neither";
    }
}
