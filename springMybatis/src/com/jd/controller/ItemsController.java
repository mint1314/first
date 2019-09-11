package com.jd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.pojo.Items;
import com.jd.pojo.QueryVo;
import com.jd.service.ItemsService;

/**
 * 商品业务的后端控制器
 * 
 * @author Derek Sun
 *
 */
@Controller
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	private String ww;

	
	/**
	 * @RequestMapping注解是将具体的URL和我们的对应的方法建立了一个从URL到方法的映射
	 * 然后将这个映射放到了一个由Springmvc维护的map对象中
	 */
	@RequestMapping("/list")
	public String getItemsList(Model model) throws Exception {
		//商品列表的查询
		List<Items> itemsList = itemsService.getItemsList();
		
		// 将查询结果集返回给页面
		model.addAttribute("itemList", itemsList);
		
		// 去掉前缀和后缀剩下的部分叫做视图的逻辑视图名
		// 页面的完整路径=前缀 + 逻辑视图名 + 后缀
		return "items/itemList";
	}
	/*@RequestMapping("/list")
	public ModelAndView getItemsList() throws Exception {
		//商品列表的查询
		List<Items> itemsList = itemsService.getItemsList();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemsList);
		modelAndView.setViewName("items/itemList");
		
		// 去掉前缀和后缀剩下的部分叫做视图的逻辑视图名
		// 页面的完整路径=前缀 + 逻辑视图名 + 后缀
		return modelAndView;
	}*/
	
	/**
	 * 演示:使用Springmvc的默认支持的类型进行传递参数
	 */
	@RequestMapping("/itemEdit")
	public String getItemById(HttpServletRequest request, Model model) throws Exception {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Items items = itemsService.getItemsById(id);
		model.addAttribute("item", items);
		return "items/editItem";
	}
	
	/**
	 * 演示:使用java简单类型传递参数
	 */
	/*@RequestMapping("/updateitem")
	public String updateItemsById(Integer id, String name, Float price, String detail) throws Exception {
		Items items = new Items();
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setDetail(detail);
		itemsService.updateItemsById(items);
		return "common/success";
	}*/
	
	/**
	 * 演示:pojo类型的参数传递
	 */
	@RequestMapping("/updateitem")
	public String updateItemsById(Items item) throws Exception {
		itemsService.updateItemsById(item);
		return "common/success";
	}
	
	/**
	 * 演示:POJO包装POJO类型的参数传递
	 */
	@RequestMapping("/queryitem")
	public String queryItems(QueryVo vo) throws Exception {
		return "common/success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
