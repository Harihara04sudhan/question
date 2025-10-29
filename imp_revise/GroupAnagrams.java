import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(words);
        
        // print result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        // map to store sorted form as key and list of words as value
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            // convert to char array
            char[] chars = word.toCharArray();
            
            // sort characters manually (no built-in sort)
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] > chars[j]) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                }
            }

            // form sorted key
            String key = new String(chars);

            // if key not present, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // add the word to its anagram group
            map.get(key).add(word);
        }

        // collect all groups into a list
        List<List<String>> output = new ArrayList<>();
        for (String key : map.keySet()) {
            output.add(map.get(key));
        }

        return output;
    }
}
