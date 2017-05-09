package reseversting;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() >= o2.length()){
			return -1;
		} else {
			return 1;
		}
	}

}
