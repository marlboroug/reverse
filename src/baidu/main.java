package baidu;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String sn = in.nextLine();
        int n = Integer.valueOf(sn.trim());
    	node[] noder = new node[50];
    	node[] nodeg = new node[50];
    	node[] nodeb = new node[50];
    	int inr = 0;
    	int ing = 0;
    	int inb = 0;
    	for (int i = 0; i < n; i++) {
    		String s = in.nextLine();
    		String[] ss = s.split("\\s+");
    		if (ss[0].equals("R")) {
    			int x = Integer.valueOf(ss[1]);
    			int y = Integer.valueOf(ss[2]);
    			int z = Integer.valueOf(ss[3]);
    			noder[inr++] = new node(x,y,z);
    		} else if(ss[0].equals("G")) {
    			int x = Integer.valueOf(ss[1]);
    			int y = Integer.valueOf(ss[2]);
    			int z = Integer.valueOf(ss[3]);
    			nodeg[ing++] = new node(x,y,z);
    		} else {
    			int x = Integer.valueOf(ss[1]);
    			int y = Integer.valueOf(ss[2]);
    			int z = Integer.valueOf(ss[3]);
    			nodeb[inb++] = new node(x,y,z);
    		}
    	}
    	double area = 0;
    	if (inr >= 3) {
    		for (int i = 0; i < inr - 2; i++) {
    			for (int j = i + 1; j < inr - 1; j++) {
    				for (int k = j + 1; k <= inr - 1; k++) {
    					area = Math.max(count_triangle_area(noder[i], noder[j], noder[k]), area);
    				}
    			}
    		}
    	}
    	if (ing >= 3) {
    		for (int i = 0; i < ing - 2; i++) {
    			for (int j = i + 1; j < ing - 1; j++) {
    				for (int k = j + 1; k <= ing - 1; k++) {
    					area = Math.max(count_triangle_area(nodeg[i], nodeg[j], nodeg[k]), area);
    				}
    			}
    		}
    	}
    	if (inb >= 3) {
    		for (int i = 0; i < inb - 2; i++) {
    			for (int j = i + 1; j < inb - 1; j++) {
    				for (int k = j + 1; k <= inb - 1; k++) {
    					area = Math.max(count_triangle_area(nodeb[i], nodeb[j], nodeb[k]), area);
    				}
    			}
    		}
    	}
    	for (int i = 0; i < inr; i++) {
			for (int j = 0; j < ing; j++) {
				for (int k = 0; k < inb; k++) {
					area = Math.max(count_triangle_area(noder[i], nodeg[j], nodeb[k]), area);
				}
			}
		}
    	System.out.println(String.format("%.5f",area));
    }
    public static double count_triangle_area(node a,node b,node c){  
        double area = -1;  
        double[]  side = new double[3];//存储三条边的长度;  
      
        side[0] = Math.sqrt(Math.pow(a.x - b.x,2)+Math.pow(a.y - b.y,2) + Math.pow(a.z - b.z,2));   
        side[1] = Math.sqrt(Math.pow(a.x - c.x,2)+Math.pow(a.y - c.y,2) + Math.pow(a.z - c.z,2));  
        side[2] = Math.sqrt(Math.pow(c.x - b.x,2)+Math.pow(c.y - b.y,2) + Math.pow(c.z - b.z,2));   
      
        //不能构成三角形;  
        if(side[0]+side[1]<=side[2] || side[0]+side[2]<=side[1] || side[1]+side[2]<=side[0]) return area;   
        //利用海伦公式。s=sqr(p*(p-a)(p-b)(p-c));   
        double p = (side[0]+side[1]+side[2])/2; //半周长;  
        area = Math.sqrt(p*(p-side[0])*(p-side[1])*(p-side[2]));   
        return area;  
    }  
}
 class node {
	int x;
	int y; 
	int z;
	public node(int x2, int y2, int z2) {
		x = x2;
		y = y2;
		z = z2;
	}
}
