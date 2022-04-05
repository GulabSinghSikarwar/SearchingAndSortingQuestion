import java.util.*;

public class InvalidBrackets {

    List<String> list;

    public List<String> removeInvalidParentheses(String s) {
        list = new ArrayList<>();
        remove(s);

        return list;
    }

    public   void remove(String str) {

        Set<String> set = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        boolean level = false;

        String temp = "";

        q.add(str);
        set.add(str);

        while (!q.isEmpty()) {
            str = q.peek();
            q.remove();

            // now check is temp is balanced string ;

            if (isBalanced(str)) {
                // System.out.println(str);
                list.add(str);
                
                level = true;

            }
            if (level)
                continue;

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                    continue;

                }

                temp = str.substring(0, i) + str.substring(i + 1);

                if (!set.contains(temp)) {
                    set.add(temp);
                    q.add(temp);

                }

            }
        }

    }

    private boolean isBalanced(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                continue;

            }
            if (str.charAt(i) == '(')
                ++count;

            if (str.charAt(i) == ')')
                --count;
            if (count < 0)
                return false;

        }
        return count == 0;
    }

    public static void main(String[] args) {

        /*
         * Example 1:
         * 
         * Input: s = "()())()"
         * Output: ["(())()","()()()"]
         * Example 2:
         * 
         * Input: s = "(a)())()"
         * Output: ["(a())()","(a)()()"]
         * Example 3:
         * 
         * Input: s = ")("
         * Output: [""]
         * 
         */
        String s = "()())()";

        // remove(s);
    }
    // OPTIMISED Java

    public List<String> removeInvalidParenthesesOne(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[] { '(', ')' });
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0])
                stack++;
            if (s.charAt(i) == par[1])
                stack--;
            if (stack >= 0)
                continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[] { ')', '(' });
        else // finished right to left
            ans.add(reversed);
    }
}
