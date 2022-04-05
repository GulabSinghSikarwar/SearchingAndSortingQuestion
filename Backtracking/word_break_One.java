import java.util.*;

public class word_break_One {

    static Set<String> set;

    public static boolean wordBreak(String s, String[] wordDict) {

        HashMap<String, Boolean> map = new HashMap<>();

        set = new HashSet<>();

        for (String ele : wordDict) {
            set.add(ele);

        }
        boolean ans = word_break(s, map);
        // System.out.println(map);
        return map.get(s);

    }

    static boolean word_break(String s, HashMap<String, Boolean> map) {
        // System.out.println(" Initial String : " + s);
        if (s.equals("")) {
            return true;

        }

        if (map.containsKey(s)) {
            // System.out.println(" starting contained in map--> S--> : "+s );

            return map.get(s);

        }
        if (set.contains(s)) {
            boolean ans = true;
            // System.out.println(" SET CONTAIN THE STRING __> " + s + " ");
            if (map.containsKey(s)) {
                map.replace(s, map.get(s), true);

            } else {
                map.put(s, true);

            }
            return true;

        }

        boolean final_ans = false;
        for (int i = 1; i <= s.length(); i++) {

            String substring = s.substring(0, i);

            if (set.contains(substring)) {
                // System.out.println("SUBSTRING EXSIST :: SUBSTRING __> " + substring);
                final_ans = true && word_break(s.substring(i), map);

                // System.out.println("STRING :: " + s + " FINAL ANSWER ::" + final_ans+ "  SUBSTRING __> " + substring);

                if (final_ans) {
                    map.put(s, true);
                    
                }
                System.out.println(map);
                if(final_ans)
                {
                    return true  ;

                }

            }

        }
        if (!map.containsKey(s)) {
            map.put(s, false);
            // return true ;
            

        }
        // System.out.println();
        // System.out.println("Final ANS : " + final_ans + " String : " + s);
        // System.out.println();
        return final_ans;
    }

    public static void main(String[] args) {
        String s = "catsandogcat";

        String[] dic = { "cats","dog","sand","and","cat","an" };

        // String s = "goalspecial";

        // String[] dic = { "go","goal","goals","special" };
        // String s = "applepenapple";

        // String[] dic = { "apple", "pen" };



        /*
         
        "catsandogcat"
["cats","dog","sand","and","cat","an"]* 
         * Example 1:
         * 
         * Input: s = "leetcode", wordDict = ["leet","code"]
         * Output: true
         * Explanation: Return true because "leetcode" can be segmented as "leet code".
         * Example 2:
         * 
         * Input: s = "applepenapple", wordDict = ["apple","pen"]
         * Output: true
         * Explanation: Return true because "applepenapple" can be segmented as
         * "apple pen apple".
         * Note that you are allowed to reuse a dictionary word.
         * Example 3:
         * 
         * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
         * Output: false
         * 
         * 
         * 
         * Input
         * "aaaaaaa"
         * ["aaaa","aaa"]
         * stdout
         * Initial String : aaaaaaa
         * Initial String : aaaa
         * Initial String : a
         * 
         * Output
         * false
         * Expected
         * true
         * 
         * 
         * "goalspecial"
         * ["go","goal","goals","special"]
         * Output
         * false
         * Expected
         * true
         * 
         */
        System.out.println("final Ans : " + wordBreak(s, dic));
    }

}
