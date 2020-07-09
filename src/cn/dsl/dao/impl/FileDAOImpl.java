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
 * �����ļ�������ʵ����
 * @author dsl
 *
 */
public class FileDAOImpl implements IFileDAO<Admin> {

	@Override
	public boolean Insert(ArrayList<Admin> vo, String filename) throws IOException {
		System.out.println("---------- ��ӹ���Ա��Ϣ ----------");
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		//д���ݵ��ļ�
		for(int i = 0; i < vo.size(); i++)
		{
			Admin a = vo.get(i);
			StringBuilder sb = new StringBuilder();
			
			//�����Ϣ
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//д���ļ�
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//�ر��ļ�
		bw.close();
		ShowAll();
		System.out.println("����Ա��Ϣ��ӳɹ�!");
		return true;
	}

	@Override
	public boolean Delete(ArrayList<Admin> vo, String name) throws IOException {
		System.out.println("---------- ɾ������Ա��Ϣ ----------");
		//���������Ƿ����
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			if(a.getAdminId().equals(name)) {
				vo.remove(i);
				break;
			}
		}
		
		//д���ݵ��ļ�
		BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
		for(int x = 0; x < vo.size(); x++)
		{
			Admin a = vo.get(x);
			StringBuilder sb = new StringBuilder();
			
			//�����Ϣ
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//д���ļ�
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//�ر��ļ�
		bw.close();
		
		if(i > vo.size()) {
			//������
			System.out.println("�û���Ϊ" + name + "�ļ�¼�����ڣ�ɾ��ʧ�ܣ�");
			return false;
		}else {
			//����
			System.out.println("�û���Ϊ" + name + "�ļ�¼ɾ���ɹ���");
			ShowAll();
			return true;
		}
	}

	@Override
	public boolean Modify(ArrayList<Admin> vo, String name, String key) throws IOException {
		System.out.println("---------- �޸Ĺ���Ա��Ϣ ----------");
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			//�м�¼����ʾ��¼
			if(a.getAdminId().equals(name)) {
				//��Ϣˢ��
				a.setPassword(key);
				System.out.println("�û���Ϊ" + name + "�Ĺ���Ա��¼�޸ĳɹ���");
				ShowAll();
				break;
			}
		}
		
		if(i > vo.size()) {
			//�޼�¼������
			System.out.println("�û���Ϊ" + name + "�Ĺ���Ա��¼�����ڣ��޸�ʧ�ܣ�");
		}
		
		//д���ݵ��ļ�
		BufferedWriter bw = new BufferedWriter(new FileWriter("admin.txt"));
		for(int x = 0; x < vo.size(); x++)
		{
			Admin a = vo.get(i);
			StringBuilder sb = new StringBuilder();
			
			//�����Ϣ
			sb.append(a.getAdminId()).append("=").append(a.getPassword());
			
			//д���ļ�
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//�ر��ļ�
		bw.close();
		return true;
	}

	@Override
	public boolean Find(ArrayList<Admin> vo, String name, String key) {
		System.out.println("---------- �û���Ϊ"+ name +"�Ĺ���Ա��Ϣ ----------");
		//���������Ƿ����
		int i = 0;
		for(; i < vo.size(); i++) {
			Admin a = vo.get(i);
			//��ѯ�ɹ�����ʾ��Ϣ
			if(a.getAdminId().equals(name) && a.getPassword().equals(key)) {
				System.out.println("�û���\t����");
				System.out.println(a.getAdminId() + "\t" + a.getPassword());
				return true;
			}
		}
		
		if(i == vo.size()) {
			//��ѯʧ��
			System.out.println("�û���Ϊ" + name + "�Ĺ���Ա��¼δ�ҵ���");
		}
		return false;
	}

	/**
	 * ��ʾ���й���Ա��Ϣ
	 * @throws IOException ���ܳ��ֵ��ļ��쳣
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
			
			//��ӵ�������
			admin.add(a);
		}
		
		//�ر��ļ�
		br.close();
		System.out.println("---------- ��ʾ���й���Ա��Ϣ ----------");
		System.out.println("�û���\t����");
		for(int x = 0; x < admin.size(); x++) {
			Admin a = admin.get(x);
			System.out.println(a.getAdminId() + "\t" + a.getPassword());
		}
	}

}
