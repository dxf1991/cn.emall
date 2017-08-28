package cn.e3mall.service;

import java.util.List;

import e3_common.EasyUITreeNode;

public interface ItemCatService {
	public List<EasyUITreeNode>getCatList(Long parentId);
		

}
