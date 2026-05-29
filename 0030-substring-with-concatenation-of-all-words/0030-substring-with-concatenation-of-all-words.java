class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int wordsLen = words.length;
        int oneWordLen = words[0].length();
        int totalLen = wordsLen * oneWordLen;

        if(n < totalLen) return result;

        Map<String, Integer> targetMap = new HashMap<>();
        for(String word : words) {
            targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
        }

        for(int offset = 0; offset < oneWordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for(int right = offset; right + oneWordLen <= n; right += oneWordLen) {
                String word = s.substring(right, right + oneWordLen);

                if(!targetMap.containsKey(word)) {
                    count = 0;
                    left = right + oneWordLen;
                    windowMap.clear();
                    continue;
                }

                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                count++;

                while(windowMap.get(word) > targetMap.get(word)) {
                    String leftWord = s.substring(left, left + oneWordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    count--;
                    left += oneWordLen;
                }

                if(count == wordsLen) {
                    result.add(left);
                    String leftWord = s.substring(left, left + oneWordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    count--;
                    left += oneWordLen;
                }
            }
        }

        return result;
    }
}