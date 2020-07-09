package cn.dsl.util;
/**
 * ���������ж��ַ����Ƿ�Ϊ�յĹ�����
 * @author dsl
 *
 */
public class StringUtil {

	/**
	 * �ж��Ƿ�Ϊ��
	 * @param str Ҫ�жϵ��ַ���
	 * @return �ǿշ���true,���򷵻�false
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * �ж��Ƿ��ǿ�
	 * @param str  Ҫ�жϵ��ַ���
	 * @return  ���ǿշ���true,���򷵻�false
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
