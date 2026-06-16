class Solution {

    public String encode(List<String> strs) {
        String output = "";
        for (String str : strs) {
            String length = "" + str.length();
            output += length + "#" + str;
        }
        return output.trim();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // 1. Parse the length
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            // 2. Move past '#'
            j++; 

            // 3. Extract the string of given length
            String word = str.substring(j, j + length);
            output.add(word);

            // 4. Move pointer forward
            i = j + length;
        }
        return output;
    }
}
