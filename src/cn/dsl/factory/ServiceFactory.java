package cn.dsl.factory;

import cn.dsl.service.IAllTableService;
import cn.dsl.service.impl.AllTableServiceImpl;
/**
 * 这是业务层的工厂类
 * @author dsl
 *
 */
public class ServiceFactory {

	/**
	 * 自动测试：得到IAllTableService接口的所有操作，调用其接口实现类，执行相应操作以实现对数据库的增删查改操作
	 * @return   IAllTableService接口
	 */
	public static IAllTableService getIAllTableServiceInstance() {
		return new AllTableServiceImpl();
	}
}
