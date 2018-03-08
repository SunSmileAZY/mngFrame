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
 * 角色菜单表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_role_authority")
public class RoleAuthority implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号自增长
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 菜单编码
     */
	@TableField("menu_code")
	private String menuCode;
    /**
     * 角色编码
     */
	@TableField("role_key")
	private String roleKey;
    /**
     * 菜单类型 1 导航 2 按钮
     */
	@TableField("menu_type")
	private Integer menuType;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	@Override
	public String toString() {
		return "RoleAuthority{" +
			"id=" + id +
			", menuCode=" + menuCode +
			", roleKey=" + roleKey +
			", menuType=" + menuType +
			"}";
	}
}
