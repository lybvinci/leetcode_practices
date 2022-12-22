import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	//44.27%
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		char[] cs = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int ret = 1;
		for (int i = 0; i < cs.length; i++) {
			set.add(cs[i]);
			for (int j = i + set.size(); j < cs.length; j++) {
				if (set.contains(cs[j])) {
					break;
				}
				set.add(cs[j]);
				ret = Math.max(ret, set.size());
			}
			set.remove(cs[i]);
		}
		return ret;
	}
}
