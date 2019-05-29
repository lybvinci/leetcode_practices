
import java.util.LinkedList;
import java.util.Stack;

public class ReverseWords {
    //49.81% 
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (sb.length() == 0 && !words.isEmpty() && " ".equals(words.getLast())) {
                    continue;
                }
                words.add(sb.toString());
                words.add(" ");
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
            sb.delete(0, sb.length());
        }
        while (!words.isEmpty()) {
            sb.append(words.pollLast());
        }
        return sb.toString().trim();

    }
}