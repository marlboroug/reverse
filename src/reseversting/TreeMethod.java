package reseversting;

import java.util.Stack;

public class TreeMethod {
	public void visitaft(TreeNode1 root){
		if (null == root){
			return;
		}
		visitaft(root.left);
		visitaft(root.right);
		System.out.println(root.val);
	}
	public void vistPre(TreeNode1 root){
		if (null == root){return;}
		Stack<TreeNode1> stack = new Stack<TreeNode1>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode1 temp = stack.pop();
			System.out.print(temp.val);
			if (null != temp.right){
				stack.push(temp.right);
			}
			if (null != temp.left){
				stack.push(temp.left);
			}
		}
	}
	public void visitIn(TreeNode1 root){
		if (null == root){return;}
		Stack<TreeNode1> stack = new Stack<TreeNode1>();
		TreeNode1 temp = root;
		//中序遍历方式有所不同，碰到左节点就入栈，左节点访问完成后，转向右子节点
		while (true){
			if (temp != null){
				stack.push(temp);
				temp = temp.left;
			} else if (!stack.isEmpty()){
				temp = stack.pop();
				System.out.print(temp.val);
				temp = temp.right;
			} else {
				break;
			}
		}
	}
	
	
	public void vistiafter(TreeNode1 root) {  
		if (null == root ){return;}
		Stack<TreeNode1> stack = new Stack<TreeNode1>();
		TreeNode1 temp = root;
		stack.push(temp);
		while (!stack.isEmpty()){
			if ((stack.peek().left != temp) && (stack.peek().right != temp)){
				//这个表示为访问的结点为未访问节点的子节点时，不调用入栈子函数，按照先右后左出栈
				getHLVFL(stack.peek(), stack);
			}
			temp = stack.pop();
			System.out.print(temp.val);
		}
	}
	public void getHLVFL(TreeNode1 temp, Stack<TreeNode1> stack){
		while(null != temp){
			if (null != temp.left){
				if (null != temp.right){
					stack.push(temp.right);
				}
				stack.push(temp.left);
			} else {
				stack.push(temp.right);
			}
			temp = stack.peek();
		}
		stack.pop();
	}
	public void findSum(TreeNodeInt root, int sum){
		int[] path = new int[getDeep(root)];
		findSumHelp(root, path, sum, 0, 0);
	}
	public void findSumHelp(TreeNodeInt root, int[] path, int sum, int add, int level){
		if (null == root){
			return;
		}
		path[level] = root.val;
		add += root.val;
		if (add == sum){
			pathPrint(path, level);
		}
		findSumHelp(root.left, path, sum, add, level + 1);
		findSumHelp(root.right, path, sum, add, level + 1);
	}
	public void pathPrint(int[] path, int level){
		for(int i = 0; i <= level; i++){
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	public int getDeep(TreeNodeInt root){
		if (null == root){
			return 0;
		}
		return (Math.max(getDeep(root.left), getDeep(root.right)) + 1);
	}
	
	
	//二叉查找树转化为有序链表
	public BinNode changeTreeToList(BinNode root){
		if (null == root){
			return null;
		}
		BinNode head= new BinNode();
		BinNode temp = root;
		BinNode temp2 = head;
		Stack<BinNode> stack = new Stack<BinNode>();
		while(true){
			if (temp != null){
				stack.push(temp);
				temp = temp.node1;//left, before
			} else if (stack.size() > 0){
				temp = stack.pop();
				BinNode node = new BinNode(temp.val);
				temp2.node2 = node;
				node.node1 = temp2 ;
				temp2 = node;
				temp = temp.node2;//right , after
			} else {
				break;
			}
		}
		head = head.node2;
		head.node1 = null;
		return head;
	}
	public NodePair convert(BinNode root){
		if (root == null){
			return null;
		}
		NodePair left = convert(root.node1);// left
		NodePair right = convert(root.node2);// right
		if (left != null){
			contact(left.tail, root);
		}
		if (right != null){
			contact(root, right.head);
		}
		return new NodePair(left == null ? root : left.head, right == null ? root : right.tail);
	}
	public void contact(BinNode no1, BinNode no2){
		no1.node2 = no2;
		no2.node1 = no1;
	}
	public class NodePair{
		BinNode head;
		BinNode tail;
		public NodePair(BinNode he, BinNode tai){
			head = he;
			tail = tai;
		}
	}
	public TreeNode1 getaf(String pre, String in ,int len){
		TreeNode1 node = new TreeNode1();
		if(len == 0){
			return null;
		}
		char root = pre.charAt(0);
		int index = 0;
		for(int i = 0; i < len; i++){
			if(root == in.charAt(i)){
				index = i;
				break;
			}
		}
		node.val = root;
		node.left = getaf(pre.substring(1,index + 1), in.substring(0, index), index );
		node.right = getaf(pre.substring(index + 1, len), in.substring(index + 1, len), len - index - 1);
		System.out.println(root);
		return node;
	}
	
	 public TreeNodeInt buildTree(int[] preorder, int[] inorder) {
		 	TreeNodeInt root = bulidHelp(preorder, inorder, 0, 0, preorder.length -1);
	        return root;
	    }
	    public TreeNodeInt bulidHelp(int[] pre, int[] in, int preroot, int left, int right) {// include left and right
	        if (left > right || preroot >= pre.length) {
	            return null;
	        }
	        int index = left;
	        while (index <= right) {
	            if (in[index] == pre[preroot]) {
	                break;
	            }
	            index++;
	        }
	        TreeNodeInt root = new TreeNodeInt(in[index]);
	        root.left = bulidHelp(pre, in, preroot + 1, left, index - 1);
	        root.right = bulidHelp(pre, in, preroot + index - left + 1, index + 1, right);
	        System.out.println(root.val);
	        return root;
	    }
	
}
