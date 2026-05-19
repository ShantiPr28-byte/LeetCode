class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int n = words.length;
        int i = 0;

        while(i < n) {
            int j = i;
            int lineLength = 0;

            while(j < n && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            //check for last line or single word
            if(j == words.length || gaps == 0) {
                //left justified
                for(int k = i; k < j; k++) {
                    line.append(words[k]);
                    if(k < j - 1) line.append(" ");
                }
                while(line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // fully justified
                int totalSpaces = maxWidth - lineLength;
                int spacePerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for(int k = i; k < j; k++) {
                    line.append(words[k]);

                    if(k < j - 1) {
                        int spaces = spacePerGap + (k - i < extraSpaces ? 1 : 0);

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