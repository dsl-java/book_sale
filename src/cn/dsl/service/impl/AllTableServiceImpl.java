package cn.dsl.service.impl;

import java.sql.ResultSet;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.service.IAllTableService;
import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;
/**
 * ����ҵ��������׼��ʵ����
 * @author dsl
 *
 */
public class AllTableServiceImpl implements IAllTableService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean Insert(BookCategory vo) throws Exception {
		try {
			// ����DAOFactory���е�getIAllTableDAOInstance()����ȡ��ICourseDAO����
			// �ڵ���getICourseDAOInstance()ʱ����Ҫͨ��DatabaseConnection����ȡ��Connection�ӿڶ��󣬴��ݽ�ȥ
			// ����ICourse�ӿ��е�toFind()�����ж�Ҫ�������ݵĿγ���Ϣ�Ƿ����
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doCreate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

	@Override
	public boolean Insert(BookInfo vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).dofind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doCreate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

	@Override
	public boolean Insert(BookSale vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).dofind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doCreate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}
	
	@Override
	public boolean Insert(Admin vo) throws Exception{
		try {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doCreate(vo);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

	@Override
	public boolean Delete(BookCategory vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doRemove(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

	@Override
	public boolean Delete(BookInfo vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doRemove(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}


	@Override
	public ResultSet Find(BookCategory vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public ResultSet Find(BookInfo vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public ResultSet Find(BookSale vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public boolean Update(BookCategory vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doUpdate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

	@Override
	public boolean Update(BookInfo vo) throws Exception {
		try {
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doUpdate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹ����г�����");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

}
