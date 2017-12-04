package com.anzy.bussiness.sys.entity;

import com.anzy.frame.comm.AbstractBaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("au_t_user")
public class User extends AbstractBaseEntity{
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId(value="user_id", type= IdType.AUTO)
    private Integer userId;
    /**
     * 用户名字
     */
    private String username;
    private String gender;
    private Integer age;
    @TableField("login_account")
    private String loginAccount;
    @TableField("login_pwd")
    private String loginPwd;
    @TableField("id_no")
    private String idNo;
    @TableField("mobile_phone")
    private String mobilePhone;
    private String email;
    private String weixin;
    @TableField("cur_state")
    private String curState;
    @TableField("login_amount")
    private Integer loginAmount;
    @TableField("dept_id")
    private Integer deptId;
    @TableField("user_no")
    private Integer userNo;
    private String address;
    private String remark;
    @TableField("create_by")
    private String createBy;
    @TableField("create_dt")
    private Date createDt;
    @TableField("update_dt")
    private Date updateDt;
    @TableField("update_by")
    private String updateBy;
    @TableField("delete_by")
    private String deleteBy;
    @TableField("act_by_type")
    private String actByType;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getCurState() {
        return curState;
    }

    public void setCurState(String curState) {
        this.curState = curState;
    }

    public Integer getLoginAmount() {
        return loginAmount;
    }

    public void setLoginAmount(Integer loginAmount) {
        this.loginAmount = loginAmount;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(String deleteBy) {
        this.deleteBy = deleteBy;
    }

    public String getActByType() {
        return actByType;
    }

    public void setActByType(String actByType) {
        this.actByType = actByType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", gender=" + gender +
                ", age=" + age +
                ", loginAccount=" + loginAccount +
                ", loginPwd=" + loginPwd +
                ", idNo=" + idNo +
                ", mobilePhone=" + mobilePhone +
                ", email=" + email +
                ", weixin=" + weixin +
                ", curState=" + curState +
                ", loginAmount=" + loginAmount +
                ", deptId=" + deptId +
                ", userNo=" + userNo +
                ", address=" + address +
                ", remark=" + remark +
                ", createBy=" + createBy +
                ", createDt=" + createDt +
                ", updateDt=" + updateDt +
                ", updateBy=" + updateBy +
                ", deleteBy=" + deleteBy +
                ", actByType=" + actByType +
                "}";
    }
}