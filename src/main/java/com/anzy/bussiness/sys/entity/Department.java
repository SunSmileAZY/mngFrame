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
 * 部门表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_department")
public class Department implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 部门编码
     */
	@TableField("department_key")
	private String departmentKey;
    /**
     * 部门名称
     */
	@TableField("department_value")
	private String departmentValue;
    /**
     * 描述
     */
	private String description;
    /**
     * 上级部门编码
     */
	@TableField("parent_departmentkey")
	private String parentDepartmentkey;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private String createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentKey() {
		return departmentKey;
	}

	public void setDepartmentKey(String departmentKey) {
		this.departmentKey = departmentKey;
	}

	public String getDepartmentValue() {
		return departmentValue;
	}

	public void setDepartmentValue(String departmentValue) {
		this.departmentValue = departmentValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentDepartmentkey() {
		return parentDepartmentkey;
	}

	public void setParentDepartmentkey(String parentDepartmentkey) {
		this.parentDepartmentkey = parentDepartmentkey;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Department{" +
			"id=" + id +
			", departmentKey=" + departmentKey +
			", departmentValue=" + departmentValue +
			", description=" + description +
			", parentDepartmentkey=" + parentDepartmentkey +
			", createTime=" + createTime +
			"}";
	}
}
