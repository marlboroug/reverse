package reseversting;

public class RankNode {
		public int left_size;
		public int data;
		public RankNode left;
		public RankNode right;
		public RankNode(int d){
			data = d;
		}
		public void insert(int d){
			if (d <= data){ //left
				if (left == null){
					left = new RankNode(d);
				} else {
					left.insert(d);
				}
				left_size++;
			} else {
				if (right == null){
					right = new RankNode(d);
				} else {
					right.insert(d);
				}
			}
		}
		public int getRankNum(int d){
			if (data == d){
				return left_size;
			} else if (d < data){
				if (left == null){
					return -1;
				}
				return left.getRankNum(d);
			} else {
				if (right == null){
					return -1;
				}
				return left_size + 1 + right.getRankNum(d);
			}
		}
}
