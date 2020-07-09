package cn.dsl.factory;

import cn.dsl.service.IAllTableService;
import cn.dsl.service.impl.AllTableServiceImpl;
/**
 * ����ҵ���Ĺ�����
 * @author dsl
 *
 */
public class ServiceFactory {

	/**
	 * �Զ����ԣ��õ�IAllTableService�ӿڵ����в�����������ӿ�ʵ���ִ࣬����Ӧ������ʵ�ֶ����ݿ����ɾ��Ĳ���
	 * @return   IAllTableService�ӿ�
	 */
	public static IAllTableService getIAllTableServiceInstance() {
		return new AllTableServiceImpl();
	}
}
