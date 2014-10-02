import java.util.StringTokenizer;

public class StringUtils {
    public static String truncate(String s, int n) {
        if (s.length() <= n) {
            return s;
        } else {
            return s.substring(0, n) + "...";
        }
    }

    public static String[] tokenize(String toTokenize, char delim) {
        String delimStr = Character.toString(delim);
        StringTokenizer st = new StringTokenizer(toTokenize, delimStr);
        String[] tokens = new String[st.countTokens()];
        for (int i = 0; st.hasMoreElements(); ++i) {
            tokens[i] = st.nextToken();
        }
        return tokens;
    }
}
