package com.sise.pojo;

import java.util.List;

/**
 * @author Manager
 * ��ҳBean����װ��ҳ����
 */
public class PageBean<T> {

	private int pc;			//��ǰҳ
//	private int tp;			//��ҳ��
	private int tr;			//�ܼ�¼��
	private int ps;			//ÿҳ��¼��
	private List<T> beanList;	//��ǰҳ����
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}

	//�ֶ�������Ҳ��
	public int getTp() {
		int tp = tr / ps;
		return tr%ps==0 ? tp : tp+1;
	}
//	public void setTp(int tp) {
//		this.tp = tp;
//	}
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
}
