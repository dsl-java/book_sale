package cn.dsl.util;
/**
 * 这是产生一万条数据的随机生成数据的操作工具类
 * @author dsl
 *
 */
public class RandomMessageUtil {

	public static String getName() {
		String[] name = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		StringBuilder random = new StringBuilder();
		for(int i = 0; i<5; i++) {
			int index = (int) (Math.random() * name.length);
			random.append(name[index]);
		}
		return random.toString();
	}
	
	public static String getPassword() {
		String[] password = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		StringBuilder random = new StringBuilder();
		for(int i = 0; i<5; i++) {
			int index = (int) (Math.random() * password.length);
			random.append(password[index]);
		}
		return random.toString();
	}
	
	
}
