package com.anzy.bussiness.sys.dao;

import com.anzy.bussiness.sys.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
public interface RoleDao extends BaseMapper<Role> {

    List<Role> listByUserId(Long userId);
}
