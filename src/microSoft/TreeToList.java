package microSoft;




public class TreeToList {
	static int xx = 1;
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
	    		TreeNode tree1 = new TreeNode(10);
	    		TreeNode tree2 = new TreeNode(6);
	    		TreeNode tree3 = new TreeNode(14);
	    		TreeNode tree4 = new TreeNode(4);
	    		TreeNode tree5 = new TreeNode(8);
	    		TreeNode tree6 = new TreeNode(12);
	    		TreeNode tree7 = new TreeNode(16);
	    		tree1.left = tree2;
	    		tree1.right = tree3;
	    		tree2.left = tree4;
	    		tree4.right = tree5;
	    		tree5.left = tree6;
	    		tree6.right = tree7;
	    	
	    		System.out.println(getMax(tree1));
	    		
	    		System.out.println(max);
	    }
	 public static int getMax (TreeNode root) {
		 if (root == null) return 0;
		 int left = getMax(root.left);
		 int right = getMax(root.right);
		 System.out.println("root : " + root.val);
		 System.out.println("left : " + left);
		 System.out.println("right : " + right);
		 max = Math.max(max, left + right);
		 return Math.max(left, right) + 1;
		 
	 }
	 public static TreeNode TransToList(TreeNode root) {
		 TreeNode resu[] =  help(root);
		 return resu[0];
	 }
	 public static TreeNode[] help(TreeNode root) {
		 TreeNode[] resu = new TreeNode[2];
		 if (root == null) {
			 resu[0] = null;
			 resu[1] = null;
			 return resu;
		 }
		 TreeNode[] resule = help(root.left);
		 TreeNode[] resuri = help(root.right);
		 if (resule[0] != null) {
			 resule[1].right = root;
			 root.left = resule[1];
			 resu[0] = resule[0];
		 } else {
			 resu[0] = root;
		 }
		 if (resuri[0] != null) {
			 resuri[0].left = root;
			 root.right = resuri[0];
			 resu[1] = resuri[1];
		 } else {
			 resu[1] = root;
		 }
		 resu[0].left = null;
		 resu[1].right = null;
		return resu;
	 }
	 
	public static boolean isPostorderResult(int a[]) {
		return helper(a, 0, a.length - 1);
	}
	public static boolean helper(int a[], int s, int e) {
		if (s == e) return true;
		int index = e - 1;
		while (index >= s && a[e] < a[index]) {
			index--;
		}
		index++;
		if (!helper(a, index, e - 1)) return false;
		for (int k = s; k < index; k++) {
			if (a[k] >= a[e]) return false;
		}
		return helper(a, s, index - 1);
	}
}
class TreeNode {
	public int val;      
	public TreeNode left;    
	public TreeNode right; 
	public TreeNode(int d) {
		val = d;
	}
}



