class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLength = words[i].length();
            int j = i + 1;
            while (j < words.length &&
                   lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder line = new StringBuilder();

            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalChars = 0;
                for (int k = i; k < j; k++) {
                    totalChars += words[k].length();
                }

                int totalSpaces = maxWidth - totalChars;
                int gaps = numWords - 1;

                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spacesPerGap;
                        if (extraSpaces > 0) {
                            spaces++;
                            extraSpaces--;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}