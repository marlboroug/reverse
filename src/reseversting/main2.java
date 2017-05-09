package reseversting;
import java.util.*;

import microSoft.TreeToList;
public class main2 {
	public static void main(String[] args) {
		TreeNodeInt root1 = new TreeNodeInt(1);
		TreeNodeInt root2 = new TreeNodeInt(2);
		TreeNodeInt root3 = new TreeNodeInt(3);
		TreeNodeInt root4 = new TreeNodeInt(4);
		TreeNodeInt root5 = new TreeNodeInt(5);
		TreeNodeInt root6 = new TreeNodeInt(6);
		TreeNodeInt root7 = new TreeNodeInt(7);
		root1.left = root2;
		root1.right = root3;
		root2.left = root4;
		root2.right = root5;
		root3.left = root6;
		root3.right = root7;
		System.out.println (getNum(root1, 10));
    }
	public static boolean getNum(TreeNodeInt root, int val) {
		// houxu
		Stack<TreeNodeInt> st = new Stack<TreeNodeInt>();
		st.push(root);
		TreeNodeInt cur = root;
		Map<TreeNodeInt, Integer> map = new HashMap();
		map.put(root, root.val);
		while (st.size() > 0) {
			if (! (cur == st.peek().left || cur == st.peek().right)) {
				getHDFL(st, st.peek(), map);
				cur = st.peek();
				System.out.println(cur.val + " " + map.get(cur));
				if (map.get(cur) == val) return true;
			}
			cur = st.pop();
			System.out.println(cur.val);
		}
		 for (TreeNodeInt in : map.keySet()) {
			             //map.keySet()返回的是所有key的值
			             int str = map.get(in);//得到每个key多对用value的值
			             System.out.println(in.val + "     " + str);
		}
		return false;
	}
	public static void getHDFL(Stack<TreeNodeInt> stack , TreeNodeInt cur, Map<TreeNodeInt, Integer> map ) {
		while (cur != null) {
			if (cur.left != null) {
				if (cur.right != null) {
					stack.push(cur.right);
					map.put(cur.right, map.get(cur) + cur.right.val);
				}
				stack.push(cur.left);
				map.put(cur.left, map.get(cur) + cur.right.val);
			} else {
				if (cur.right != null)
					map.put(cur.right, map.get(cur) + cur.right.val);
				stack.push(cur.right);
			}
			cur = stack.peek();
		} 
		stack.pop();
	}
}