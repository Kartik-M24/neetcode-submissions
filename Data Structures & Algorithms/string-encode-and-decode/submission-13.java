class Solution {

    public String encode(List<String> strs) {
        // The idea is we take all the strings and convert into a singular string (a sentence) and must be abel to decode it afterwards
        // In order to do so the main thing to think about is how can we decode the string so that when we iterate through the string in d4ecode 
        // we know where to split

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#"); 
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        int prevCount = 0;
        while (i < str.length()) {
            if (str.charAt(i) != '#') {
                i++;
                continue;
            }
            int index = Integer.parseInt(str.substring(prevCount, i));
            output.add(str.substring(i + 1, i + 1 + index));
            i = i + 1 + index;
            prevCount = i;
        }

        return output;
    }
}
