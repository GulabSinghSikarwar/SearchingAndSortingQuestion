public class valid_palin_Two {
   /*
    public static boolean validPalindrome(String s) {
        //

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(sub))
                return true;

            // System.out.println("Index :  " + i + "___ :: substring __ " + sub);

        }

        return false;
    }
     */

    static boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;

        if (s.length() == 1)
            return true;
        boolean remaining = false;

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            remaining = true && isPalindrome(s.substring(1, s.length() - 1));

        }

        return remaining;
    } 

    public static  boolean validPalindrome(String s) {
     
        int i=0;
        int j=s.length()-1;
        int count=0;


        while(j>=0 && i<s.length()-1 && i<=j )
        {
            if(s.charAt(i) !=s.charAt(j) )
            {
                String s1=s.substring(0, i)+s.substring(i+1);
                String s2=s.substring(0, j)+s.substring(j+1);

                
                return isPalindrome(s1)|| isPalindrome(s2);

            }
            i++;
            j--;

        }
        
     return false ;
    }

    public static void main(String[] args) {
        // as
        // System.out.println(isPalindrome("bbb"));
        // System.out.println("Final Answer : : "+ validPalindrome("bcdb"));

    }
}
