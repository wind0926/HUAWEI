package com.offcn.ssm.pojo;

import java.util.List;

public class PageBean<E> {
	public static Integer pageSize = 5;  // 每页显示的记录数
	private Integer curPage;  // 当前页数
	private Integer totalPage;  // 总页数
	private Integer totalSize;	// 总记录数
	private List<E> list;	// 每页存储的数据
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [curPage=" + curPage + ", totalPage=" + totalPage + ", totalSize=" + totalSize + ", pageSize="
				+ pageSize + ", list=" + list + "]";
	}
	
}
