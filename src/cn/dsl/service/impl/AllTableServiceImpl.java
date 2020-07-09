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
 * 这是业务层操作标准的实现类
 * @author dsl
 *
 */
public class AllTableServiceImpl implements IAllTableService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public boolean Insert(BookCategory vo) throws Exception {
		try {
			// 利用DAOFactory类中的getIAllTableDAOInstance()方法取得ICourseDAO对象
			// 在调用getICourseDAOInstance()时候需要通过DatabaseConnection对象取得Connection接口对象，传递进去
			// 调用ICourse接口中的toFind()方法判断要增加数据的课程信息是否存在
			if(DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doFind(vo) != null) {
				return DAOFactory.getIAllTableDAOInstance(this.dbc.getConn()).doCreate(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
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
			System.out.println("数据库连接过程中出错了");
		}finally {
			this.dbc.closeCon();
		}
		return false;
	}

}
