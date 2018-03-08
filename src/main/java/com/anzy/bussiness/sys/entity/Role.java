package com.anzy.bussiness.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.anzy.frame.comm.AbstractBaseEntity;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_role")
public class Role implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="role_id", type= IdType.AUTO)
	private Integer roleId;
    /**
     * 角色编码
     */
	@TableField("role_key")
	private String roleKey;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private String createTime;
    /**
     * 描述
     */
	private String description;
    /**
     * 角色名称
     */
	@TableField("role_value")
	private String roleValue;
	@TableField("company_id")
	private Long companyId;

	private String  permissions;

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleValue() {
		return roleValue;
	}

	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Role{" +
			"roleId=" + roleId +
			", roleKey=" + roleKey +
			", createTime=" + createTime +
			", description=" + description +
			", roleValue=" + roleValue +
			", companyId=" + companyId +
			"}";
	}
}
