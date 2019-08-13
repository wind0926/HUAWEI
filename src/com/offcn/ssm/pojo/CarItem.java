package com.offcn.ssm.pojo;

import java.io.Serializable;

/**
 * 购物项实体类
 */
public class CarItem implements Serializable{
	private static final long serialVersionUID = 3310354663352287925L;
	private Product product;
	private Integer count;
	private Double subTotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubTotal() {
		//写一个计算价格小计的公式:商品的单价*商品数量
		return product.getShop_price()*count;
	}
	@Override
	public String toString() {
		return "CarItem [product=" + product + ", count=" + count + ", subTotal=" + subTotal + "]";
	}
}
