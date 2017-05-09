package reseversting;

public class NumArray {
	    
	    private int[] nums;
	    public NumArray(int[] nums) {
	        this.nums=nums;
	    }

	    public int sumRange(int i, int j) {
	        int result = 0;
	        for( int temp=i;temp<=j;temp++ ){
	            result += nums[temp];
	            System.out.println("temp"+temp);
	        }
	        return result;
	    }

}
