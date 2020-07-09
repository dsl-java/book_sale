package cn.dsl.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cn.dsl.dao.IFileDAO;
import cn.dsl.vo.Admin;
/**
 * 这是文件操作的实现类
 * @author dsl
 *
 */
public class FileDAOImpl implements IFileDAO<Admin> {

	@Override
	public boolean Insert(ArrayList<Admin> vo, String filename) throws IOException {
		System.out.println("---------- 添加管理员信息 ----------");
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		//写数据到文件
		for(int i = 0; i < vo.size(); i++)
		{
			Admin a = vo.get(i);
			StringBuilder sb = new StringBuilder();
			
			//添加信息
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//写入文件
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//关闭文件
		bw.close();
		ShowAll();
		System.out.println("管理员信息添加成功!");
		return true;
	}

	@Override
	public boolean Delete(ArrayList<Admin> vo, String name) throws IOException {
		System.out.println("---------- 删除管理员信息 ----------");
		//看集合中是否存在
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			if(a.getAdminId().equals(name)) {
				vo.remove(i);
				break;
			}
		}
		
		//写数据到文件
		BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
		for(int x = 0; x < vo.size(); x++)
		{
			Admin a = vo.get(x);
			StringBuilder sb = new StringBuilder();
			
			//添加信息
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//写入文件
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//关闭文件
		bw.close();
		
		if(i > vo.size()) {
			//不存在
			System.out.println("用户名为" + name + "的记录不存在，删除失败！");
			return false;
		}else {
			//存在
			System.out.println("用户名为" + name + "的记录删除成功！");
			ShowAll();
			return true;
		}
	}

	@Override
	public boolean Modify(ArrayList<Admin> vo, String name, String key) throws IOException {
		System.out.println("---------- 修改管理员信息 ----------");
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			//有记录则显示记录
			if(a.getAdminId().equals(name)) {
				//信息刷新
				a.setPassword(key);
				System.out.println("用户名为" + name + "的管理员记录修改成功！");
				ShowAll();
				break;
			}
		}
		
		if(i > vo.size()) {
			//无记录，返回
			System.out.println("用户名为" + name + "的管理员记录不存在，修改失败！");
		}
		
		//写数据到文件
		BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
		for(int x = 0; x < vo.size(); x++)
		{
			Admin a = vo.get(i);
			StringBuilder sb = new StringBuilder();
			
			//添加信息
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//写入文件
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//关闭文件
		bw.close();
		return true;
	}

	@Override
	public boolean Find(ArrayList<Admin> vo, String name, String key) {
		System.out.println("---------- 用户名为"+ name +"的管理员信息 ----------");
		//看集合中是否存在
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			//查询成功，显示信息
			if(a.getAdminId().equals(name) && a.getPassword().equals(key)) {
				System.out.println("用户名\t密码");
				System.out.println(a.getAdminId() + "\t" + a.getPassword());
				return true;
			}
		}
		
		if(i == vo.size()) {
			//查询失败
			System.out.println("用户名为" + name + "的管理员记录未找到！");
		}
		return false;
	}

	/**
	 * 显示所有管理员信息
	 * @throws IOException 可能出现的文件异常
	 */
	public void ShowAll() throws IOException {
		ArrayList <Admin> admin = new ArrayList <Admin> ();
		BufferedReader br = new BufferedReader(new FileReader("admin.txt"));
		String ch;
		while((ch = br.readLine()) != null) {
			String[] adminData = ch.split("=");
			Admin a = new Admin();
			a.setAdminId(adminData[0]);
			a.setPassword(adminData[1]);
			
			//添加到集合中
			admin.add(a);
		}
		
		//关闭文件
		br.close();
		System.out.println("---------- 显示所有管理员信息 ----------");
		System.out.println("用户名\t密码");
		for(int x = 0; x < admin.size(); x++) {
			Admin a = admin.get(x);
			System.out.println(a.getAdminId() + "\t" + a.getPassword());
		}
	}

}
