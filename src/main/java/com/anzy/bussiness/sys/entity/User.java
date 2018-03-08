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
 * 用户表
 * </p>
 *
 * @author anzy
 * @since 2018-03-08
 */
@TableName("sys_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="user_id", type= IdType.AUTO)
	private Long userId;
    /**
     * 登录账号
     */
	@TableField("login_account")
	private String loginAccount;
    /**
     * 登录密码
     */
	@TableField("login_pass")
	private String loginPass;
    /**
     * 昵称
     */
	@TableField("user_name")
	private String userName;
    /**
     * 头像
     */
	@TableField("user_head")
	private String userHead;
    /**
     * 手机
     */
	@TableField("user_phone")
	private String userPhone;
    /**
     * 邮箱
     */
	@TableField("user_email")
	private String userEmail;
    /**
     * 性别
     */
	@TableField("user_sex")
	private Integer userSex;
    /**
     * 生日
     */
	@TableField("user_birthday")
	private String userBirthday;
    /**
     * 注册时间
     */
	@TableField("register_time")
	private String registerTime;
    /**
     * 部门编码
     */
	@TableField("department_key")
	private String departmentKey;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getDepartmentKey() {
		return departmentKey;
	}

	public void setDepartmentKey(String departmentKey) {
		this.departmentKey = departmentKey;
	}

	@Override
	public String toString() {
		return "User{" +
			"userId=" + userId +
			", loginAccount=" + loginAccount +
			", loginPass=" + loginPass +
			", userName=" + userName +
			", userHead=" + userHead +
			", userPhone=" + userPhone +
			", userEmail=" + userEmail +
			", userSex=" + userSex +
			", userBirthday=" + userBirthday +
			", registerTime=" + registerTime +
			", departmentKey=" + departmentKey +
			"}";
	}
}
