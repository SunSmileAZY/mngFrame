package com.anzy.bussiness.sys.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author anzy
 * @since 2018-04-13
 */
@TableName("sys_log")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="ID", type= IdType.AUTO)
	private Integer id;
    /**
     * 系统类别
     */
	@TableField("system_type")
	private String systemType;
    /**
     * 日志级别
     */
	private String level;
	@TableField("Logger_Name")
	private String loggerName;
	private String message;
	private String detail;
	@TableField("ip_Address")
	private String ipAddress;
	@TableField("host_Name")
	private String hostName;

	@TableField("LOG_DT")
	@JSONField(format= "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
	private Date logDt;
	private String operater;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Date getLogDt() {
		return logDt;
	}

	public void setLogDt(Date logDt) {
		this.logDt = logDt;
	}

	public String getOperater() {
		return operater;
	}

	public void setOperater(String operater) {
		this.operater = operater;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	@Override
	public String toString() {
		return "Log{" +
			"id=" + id +
			", systemType=" + systemType +
			", level=" + level +
			", loggerName=" + loggerName +
			", message=" + message +
			", detail=" + detail +
			", ipAddress=" + ipAddress +
			", hostName=" + hostName +
			", logDt=" + logDt +
			"}";
	}
}
