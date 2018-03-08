package com.anzy.bussiness.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.anzy.frame.comm.AbstractBaseEntity;

/**
 * <p>
 * 用户角色映射表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_user_role")
public class UserRole implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId("user_id")
	private Long userId;
    /**
     * 角色编号
     */
	@TableField("role_id")
	private Integer roleId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole{" +
			"userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
