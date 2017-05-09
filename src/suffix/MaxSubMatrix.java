package suffix;

public class MaxSubMatrix {
	public void clearArray(int[] array){
		for (int i = 0; i < array.length; i++){
			array[i] = 0;
		}
	}
	public int maxSubArray(int[] arr, int n){
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++){
			sum += arr[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}
	public int maxSubMatrix(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int[] partilSum = new int[col];
		int max = Integer.MIN_VALUE;
		int x = 0;
		int y = 0;
		for (int rowb = 0; rowb < row; rowb++){
			clearArray(partilSum);
			for (int rowe = rowb; rowe < row; rowe++){
				for (int co = 0; co < col; co++){
					partilSum[co] += matrix[rowe][co];
				}
				for (int a : partilSum){
				}
				int runmax = maxSubArray(partilSum, col);
				if (runmax > max){
					max = runmax;
					x = rowb;
					y = rowe;
				}
			}	
		}
		return max;
	}
}
