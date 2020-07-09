package cn.dsl.junit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import cn.dsl.factory.ServiceFactory;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;
import junit.framework.TestCase;
/**
 * ����ҵ���Ĳ����࣬�������Դ����Ƿ���ȷ
 * @author dsl
 *
 */
@SuppressWarnings("unused")
class IAllTableServiceTest {

	@Test
	void testInsertBookCategory() {
		BookCategory vo = new BookCategory("G0012","������");
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInsertBookInfo() {
		BookInfo vo=new BookInfo();
		vo.setBookId("00021");
		vo.setBookName("�ۺϽ̳�");
		vo.setCategoryId("G0005");
		vo.setAuthor("С��");
		vo.setPublisher("�廪��ѧ������");
		vo.setPublishDate("2020-07-03");
		vo.setPurchase(48.0);
		vo.setPrice(50.0);
		vo.setStock(100);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInsertBookSale() {
		BookSale vo = new BookSale("S0006","00021",54,"2019-12-04",66);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindBookCategory() {
		BookCategory vo = new BookCategory("G0012","������");
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Find(vo) != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindBookInfo() {
		BookInfo vo=new BookInfo();
		vo.setBookId("00021");
		vo.setBookName("�ۺϽ̳�");
		vo.setCategoryId("G0005");
		vo.setAuthor("С��");
		vo.setPublisher("�廪��ѧ������");
		vo.setPublishDate("2020-07-03");
		vo.setPurchase(48.0);
		vo.setPrice(50.0);
		vo.setStock(100);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Find(vo) != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFindBookSale() {
		BookSale vo = new BookSale("S0006","00021",54,"2019-12-04",66);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Find(vo) != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateBookCategory() {
		BookCategory vo = new BookCategory("G0012","��Ϸ��");
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateBookInfo() {
		BookInfo vo=new BookInfo();
		vo.setBookId("00021");
		vo.setBookName("��ѧӢ��");
		vo.setCategoryId("G0005");
		vo.setAuthor("С��");
		vo.setPublisher("�廪��ѧ������");
		vo.setPublishDate("2020-05-15");
		vo.setPurchase(66.0);
		vo.setPrice(50.0);
		vo.setStock(100);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testDelelteBookCategory() {
		BookCategory vo = new BookCategory("G0012","��Ϸ��");
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Delete(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDeleteBookInfo() {
		BookInfo vo=new BookInfo();
		vo.setBookId("00021");
		vo.setBookName("��ѧӢ��");
		vo.setCategoryId("G0005");
		vo.setAuthor("С��");
		vo.setPublisher("�廪��ѧ������");
		vo.setPublishDate("2020-05-15");
		vo.setPurchase(66.0);
		vo.setPrice(50.0);
		vo.setStock(100);
		try {
			TestCase.assertTrue(ServiceFactory.getIAllTableServiceInstance().Delete(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
