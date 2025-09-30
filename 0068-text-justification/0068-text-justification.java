class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int gaps = last - index - 1;

            if (last == n || gaps == 0) {
                
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) sb.append(" ");
                }

                while (sb.length() < maxWidth) sb.append(" ");
            } else {
               
                int spaces = (maxWidth - totalChars) / gaps;
                int extra = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i != last - 1) {
                        int spaceCount = spaces + 1;
                        if (extra > 0) {
                            spaceCount++;
                            extra--;
                        }
                        for (int s = 0; s < spaceCount; s++) sb.append(" ");
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }

        return result;
    }
}
