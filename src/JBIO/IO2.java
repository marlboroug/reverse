package JBIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO2 {
	public static void main( String[] args ) throws IOException{ 
	  /*  File file1 =new File("2small.out");
	     //if file doesnt exists, then create it
	     file1.delete();
	     if(!file1.exists()){
	      file1.createNewFile();
	     }
	
	     //true = append file
	     FileWriter fileWritter = new FileWriter(file1.getName(),true);
	     BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	   File file = new File("B-small-attempt3.in");
	   BufferedReader reader = null;
	   try {
	       reader = new BufferedReader(new FileReader(file));
	       String tempString = null;
	       // 一次读入一行，直到读入null为文件结束
	       int m = 0;
	       tempString = reader.readLine();
	       m = Integer.valueOf(tempString);
	   	
	       for (int i = 1; i <= m ; i++) {
	       	tempString = reader.readLine();
	       	int num = Integer.valueOf(tempString);
	       	
	       	double[][] points = new double[num][3];
     		double minx = Double.MAX_VALUE;
     		double miny = minx;
     		double maxx = Double.MIN_VALUE;
     		double maxy = maxx;
	       	for (int j = 0; j < num; j++) {
	       		tempString = reader.readLine();
	     		String[] nums = tempString.split("\\s+");
     			points[j][0] = Double.valueOf(nums[0]);
     			points[j][1] =  Double.valueOf(nums[1]);
     			points[j][2] =  Double.valueOf(nums[2]);
     		}
	       	double re = getMinimum(minx, maxx, miny, maxy, points);
	       	String he = "Case #" + i + ": " + re ;
	       	System.out.println("he " + he);
	       	bufferWritter.write(he);
	       	bufferWritter.newLine();
	       } 
	       System.out.println("done");
	       reader.close();
	       bufferWritter.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   } finally {
	       if (reader != null) {
	           try {
	               reader.close();
	           } catch (IOException e1) {
	           }
	       }
	   }*/
		char[][] tree = new char[][]{{'.','.','#','.','.'},{'.','#','#','#','.'},{'#','#','#','#', '#'}};
		
	}
	

	}
	
	

