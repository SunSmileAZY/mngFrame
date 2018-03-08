package com.anzy.bussiness.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.anzy.frame.comm.AbstractBaseEntity;

/**
 * <p>
 * 角色按钮权限表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_role_permission")
public class RolePermission implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 角色主键编号
     */
	@TableField("role_id")
	private Integer roleId;
    /**
     * 按钮权限
     */
	private String permissions;


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "RolePermission{" +
			"roleId=" + roleId +
			", permissions=" + permissions +
			"}";
	}
}
