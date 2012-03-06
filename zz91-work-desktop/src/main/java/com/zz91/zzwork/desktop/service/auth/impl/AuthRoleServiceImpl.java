/**
 * Copyright 2011 ASTO.
 * All right reserved.
 * Created on 2011-5-5
 */
package com.zz91.zzwork.desktop.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.zz91.zzwork.desktop.dao.auth.AuthRightDao;
import com.zz91.zzwork.desktop.dao.auth.AuthRoleDao;
import com.zz91.zzwork.desktop.domain.auth.AuthRight;
import com.zz91.zzwork.desktop.domain.auth.AuthRole;
import com.zz91.zzwork.desktop.dto.ExtTreeDto;
import com.zz91.zzwork.desktop.service.auth.AuthRoleService;

/**
 * @author mays (mays@zz91.com)
 *
 * created on 2011-5-5
 */
@Component("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
	
	@Resource
	private AuthRoleDao authRoleDao;
	
	@Resource
	private AuthRightDao authRightDao;

	@Override
	public Integer createRole(AuthRole role) {
		return authRoleDao.insertRole(role);
	}

	@Override
	public Integer deleteRole(Integer roleId) {
		authRoleDao.deleteRightOfRole(roleId);
		return authRoleDao.deleteRole(roleId);
	}

	@Override
	public List<AuthRole> queryRole() {
		return authRoleDao.queryRole();
	}

	@Override
	public List<ExtTreeDto> queryRightTreeNode(String parentCode, Integer roleId) {
		List<ExtTreeDto> nodeList = new ArrayList<ExtTreeDto>();
		if(roleId==null || roleId.intValue()<=0){
			return nodeList;
		}
		List<Integer> roleRight = authRoleDao.queryRightIdOfRole(roleId);
		List<AuthRight> rightList = authRightDao.queryChild(parentCode);
		
		if(rightList==null){
			return nodeList;
		}
		
		for(AuthRight right:rightList){
			ExtTreeDto node = new ExtTreeDto();
			node.setId(String.valueOf(right.getId()));
			node.setData(right.getCode());
			node.setText(right.getName());
			Integer i = authRightDao.countChild(right.getCode());
			if(i==null || i.intValue()<=0){
				node.setLeaf(true);
			}
			if(roleRight.contains(right.getId())){
				node.setChecked(true);
			}else{
				node.setChecked(false);
			}
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public Integer updateRole(AuthRole role) {
		
		return authRoleDao.updateRole(role);
	}

	@Override
	public Integer updateRoleRight(Integer roleId, Integer rightId,
			Boolean checked) {
		if(checked==null){
			checked=false;
		}
		
		Integer i=0;
		if(checked){
			i=authRoleDao.insertRoleRight(roleId, rightId);
		}else{
			i=authRoleDao.deleteRoleRight(roleId, rightId);
		}
		
		return i;
	}

}
