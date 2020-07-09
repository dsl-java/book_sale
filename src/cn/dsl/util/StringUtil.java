package cn.dsl.util;
/**
 * 这是用来判断字符串是否为空的工具类
 * @author dsl
 *
 */
public class StringUtil {

	/**
	 * 判断是否为空
	 * @param str 要判断的字符串
	 * @return 是空返回true,否则返回false
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str  要判断的字符串
	 * @return  不是空返回true,否则返回false
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
