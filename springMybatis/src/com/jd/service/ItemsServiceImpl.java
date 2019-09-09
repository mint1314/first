package com.jd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.dao.ItemsMapper;
import com.jd.pojo.Items;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsDao;

	@Override
	public List<Items> getItemsList() throws Exception {
		List<Items> list = itemsDao.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public Items getItemsById(Integer id) throws Exception {
		Items items = itemsDao.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItemsById(Items items) throws Exception {
		itemsDao.updateByPrimaryKeySelective(items);
		
	}

}
