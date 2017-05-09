package reseversting;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode1 root) {
        
        List<TreeNode1> list = new LinkedList<>();
        List<String> result = new LinkedList<>();
        TreeNode1 node = null;
        list.add(root);
        while( list.size()>0 ){
            node = list.remove(0);
            if( null==node){
                result.add("null");
            }else{
                result.add(String.valueOf(node.val));
                list.add(node.left);
                list.add(node.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<result.size();i++  ){
            sb.append(result.get(i));
            sb.append(",");
        }
        String a= sb.substring(0, sb.length()-1);
        return a;
    }

    // Decodes your encoded data to tree.
    public TreeNode1 deserialize(String data) {
        String[] res = data.split(",");
        List<String> result = new LinkedList(Arrays.asList(res));
        return des(result,0);
    }
    
    public TreeNode1 des(List<String> result,int ids){
    	System.out.println("ids: "+ids);
    	System.out.println("size: "+(result.size()+1));
    	int a=result.size()-1;
        if( ids > a ){
        	System.out.println("yuejie: "+result.size());
            return null;
        }
        if( result.get(ids).equals("null") ){
        	return null;
        }
        TreeNode1 root = new TreeNode1(Integer.valueOf(result.get(ids) ));
        root.left = des(result,2*ids+1  );
        root.right = des(result,2*ids+2);
        
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));