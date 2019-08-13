package com.offcn.ssm.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Car implements Serializable{
	private static final long serialVersionUID = -503642238369645287L;
	private Double totalPrice;
	private Map<String,CarItem> items = new HashMap<>();
	public Double getTotalPrice() {
		//通过公式计算总价格
		//totalPrice = 所有CarItem的价格小计之和
		//每次遍历之前，将totalPrice赋值为0
		totalPrice = 0.0;
		//遍历items
		Set<String> keySet = items.keySet();//获取所有的key
		for (String key : keySet) {
			//遍历出每一个key,通过每一个key获取对应的value
			CarItem carItem = items.get(key);
			totalPrice += carItem.getSubTotal();
		}
		return totalPrice;
	}
	public Map<String, CarItem> getItems() {
		return items;
	}
	//封装一个方法，来添加购物项
	public void add2Car(CarItem carItem){
		//得根据key判断，如果这个购物项已经存在了，不去覆盖它，而是累加
		String key = carItem.getProduct().getPid();
		if (items.containsKey(key)) {
			//表示这个购物项已经存在了
			//取出原来的数量
			CarItem carItem2 = items.get(key);//原来存在的
			Integer count2 = carItem2.getCount();//原来的数量
			
			Integer count = carItem.getCount();//这次的数量
			
			count = count + count2;//表示将两次数量相加
			
			//设置购物项的数量为改变后的数量
			carItem.setCount(count);
		}
		items.put(carItem.getProduct().getPid(), carItem);
	}
	
	/**
	 * 从购物车中移除商品
	 * @param pid
	 */
	public void remove(String pid){
		items.remove(pid);
	}
	public void clear(){
		items.clear();
	}
}
