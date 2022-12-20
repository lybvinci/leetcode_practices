public class CountPrefixes {
	//100.00%
	public int countPrefixes(String[] words, String s) {
		int count = 0;
		for (String s1 : words) {
			if (s.startsWith(s1)) {
				count++;
			}
		}
		return count;
	}	
}
