package reseversting;
class R extends Thread{
	private static int count=10;
	private int i;
	public R(int i)
	{
		this.i=i;
	}
	
	public void run()
	{
		if(i==1){
			System.out.println("**");
			System.out.println("1:" + count++);
			System.out.println("**");
		} else {
			System.out.println("--");
			System.out.println("2: "+ count--);
			System.out.println("--");
		}
			
	}
}