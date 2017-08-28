package cn.e3mall.service;

import java.util.List;

import cn.e3mall.pojo.TbItem;
import e3_common.EasyUIDataGridResult;

public interface ItemService {
	public TbItem findById(Long id);

	public EasyUIDataGridResult findItemList(int page,int rows);

}
