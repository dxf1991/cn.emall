package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
import e3_common.EasyUIDataGridResult;


@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{id}")
	@ResponseBody
	public TbItem findById(@PathVariable Long id){
		TbItem item = itemService.findById(id);
		return item;
		
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult findItemList(int page,int rows){
		
		return itemService.findItemList(page, rows);
		
	}

}
