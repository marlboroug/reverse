package JNETTY;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 9090;
		}
		new Server(port).run();
	}
}
// ecplise ��������ʹ�õ�jar����Ҫ�� export runable������