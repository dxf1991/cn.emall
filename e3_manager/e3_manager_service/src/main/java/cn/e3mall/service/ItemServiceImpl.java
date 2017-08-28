package cn.e3mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import e3_common.EasyUIDataGridResult;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem findById(Long id) {
		//根据主键查询
		//TbItem item = itemMapper.selectByPrimaryKey(id);
		//自定义查询
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		 criteria.andIdEqualTo(id);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult findItemList(int page,int rows){
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页信息
		PageInfo <TbItem>pageInfo=new PageInfo<>(list);
		Integer total = (int) pageInfo.getTotal();
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(total);
		result.setRows(list);
		return result;
	}

}
