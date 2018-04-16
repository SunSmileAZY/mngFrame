package com.anzy.bussiness.sys.dao;

import com.anzy.bussiness.sys.entity.RolePermission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色按钮权限表 Mapper 接口
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
public interface RolePermissionDao extends BaseMapper<RolePermission> {

    List<String> listByRoleId(Integer roleId);

}
