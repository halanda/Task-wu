package Code;

public class Code {
//	随机产生4个字母的验证码
	public static String getRandomCode() {
//		定义一个数组
		char[] arr = new char[52];
		for (int i = 0; i < 26; i++) {
			arr[i] = (char)(65+i); //ascll A=65
		}
		for (int i = 26; i < arr.length; i++) {
			arr[i] = (char)(97+i-26); //ascll a=97
		}
		String str ="";
		for (int i = 0; i < 4; i++) {
			int index = (int)(Math.random()*53);
			
			str+= arr[index];
			
		}
		return str;
		
	}
	public static void main(String[] args) {
		Code c = new Code();
		System.out.println(c.getRandomCode());
	}
}
