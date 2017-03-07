package com.sise.pojo;

import java.util.List;

/**
 * @author Manager
 * 分页Bean，封装分页数据
 */
public class PageBean<T> {

	private int pc;			//当前页
//	private int tp;			//总页数
	private int tr;			//总记录数
	private int ps;			//每页记录数
	private List<T> beanList;	//当前页数据
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}

	//手动计算总也数
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
