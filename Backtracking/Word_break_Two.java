import java.util.*;

public class Word_break_Two {

    public static void main(String[] args) {

        String s = "iloveicecreamandmango";

        String[] dic = {"mobile","samsung","sam","sung",
        "man","mango", "icecream","and",
        "go","i","love","ice","cream"};

        /*
        ["pine apple pen apple",
        "pineapple pen apple",
        "pine applepen apple"]-
        */


        /*
        [pine apple pen apple ,
         pine applepen apple ,
         pineapple pen apple ]

        */
       System.out.println( wordBreak(s, dic));

    }

    static Set<String> set;
     static List <String > list ;


    public static List<String> wordBreak(String s, String[] wordDict) {
    
        set = new HashSet<>();
        list=new ArrayList<>();

    
        for (String ele : wordDict) {
            set.add(ele);
        }
        String ans = "";

        confirm_break(s, ans);

        return list;
    }

    private static void confirm_break(String s, String ans) {

        // System.out.println("String Is: " + s);
        // if (s.equals("")) {
        //     // String finalString=ans.trim();
        //     list.add(ans);

        //     // System.out.println(" Our ANS IS  :: "+ans);
        //     return;
        // }

        // System.out.println();

        int n = s.length();
        // System.out.println("Current Starting String : " + s);

        for (int i = 1; i <= n; i++) {
            String max_subSTring_possible_by_now = s.substring(0, i);

            // System.out.println(" max_substring :: " + max_subSTring_possible_by_now);

            if (set.contains(max_subSTring_possible_by_now)) {

                if(i==n)
                {
                    ans+=max_subSTring_possible_by_now;
                    
                   System.out.println(ans);
                   return 
                   ;

                }
                
                confirm_break(s.substring(i), ans+max_subSTring_possible_by_now+" ");
                // System.out.println();
            }

        }

    }

}
