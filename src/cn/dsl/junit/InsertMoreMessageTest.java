package cn.dsl.junit;

import org.junit.jupiter.api.Test;

import cn.dsl.factory.ServiceFactory;
import cn.dsl.util.RandomMessageUtil;
import cn.dsl.vo.Admin;
import junit.framework.TestCase;
/**
 * 这是增加用户信息的一万条数据的测试类
 * @author dsl
 *
 */
class InsertMoreMessageTest {

	@Test
	void testInsertAdmin() {
		for(int i = 1; i < 10001; i++) {
			// 编号
			StringBuilder id = new StringBuilder("A");
			if(i < 10) {
				id.append("0000").append(i);
			}else if(i >= 10 && i < 100) {
				id.append("000").append(i);
			}else if(i >= 100 && i < 1000) {
				id.append("00").append(i);
			}else if(i >= 1000 && i < 10000) {
				id.append("0").append(i);
			}else {
				id.append(i);
			}

			Admin vo = new Admin(id.toString(), RandomMessageUtil.getName(), RandomMessageUtil.getPassword());
			try {
				TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Insert(vo));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
