package com.jd.service;

import java.util.List;

import com.jd.pojo.Items;

public interface ItemsService {
	
	// 查询全部的商品信息列表
	public List<Items> getItemsList() throws Exception;
	
	// 根据id查询商品信息
	public Items getItemsById(Integer id) throws Exception;
	
	// 根据id更新商品信息
	public void updateItemsById(Items item) throws Exception;

}
