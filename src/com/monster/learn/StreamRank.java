import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//5.63%
public class StreamRank {
	private HashMap<Integer, Integer> map;
	public StreamRank() {
		map = new HashMap<>();
	}
	
	public void track(int x) {
		map.put(x, map.getOrDefault(x, 0) + 1);
	}
	
	public int getRankOfNumber(int x) {
		List<Integer> set = new ArrayList<>(map.keySet());
		Collections.sort(set);
		int count = 0;
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i) > x) {
				break;
			}
			count += map.get(set.get(i));
		}
		return count;
	}
}
