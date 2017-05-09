package reseversting;

public class Bitman {
	public String numTobin(double num){
		if (num >= 1 || num <= 0){
			return "ERROR";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("0.");
		while(num > 0){
			num *= 2;
			if (num >= 1){
				num -= 1;
				sb.append(1);
			}else {
				sb.append(0);
			}
			if (sb.length() >= 32){
				return "ERROR";
			}
		}
		return sb.toString();
	}
}
