package com.assp.common;

import java.io.Serializable;

public class ResultBean<CODE extends ErrorCode, DATA> implements Serializable {
	private static final long serialVersionUID = 1L;
	boolean success;
	String errMsg;
	DATA data;
	CODE errCode;
	String helpMsg;

	public ResultBean() {
		this.success = true;
	}

	public ResultBean(DATA data) {
		this.data = data;
		this.success = true;
	}

	public ResultBean(boolean success, DATA data) {
		this.data = data;
		this.success = success;
	}

	public ResultBean(CODE errCode) {
		this.errCode = errCode;
		this.success = false;
	}

	public ResultBean(CODE errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.success = false;
	}

	public ResultBean(CODE errCode, String errMsg, DATA data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
		this.success = false;
	}

	public ResultBean(boolean success, CODE errCode, String errMsg, DATA data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
		this.success = success;
	}

	public void initSuccess(DATA data) {
		init(true, null, null, data);
	}

	public void initError(CODE errCode) {
		init(false, errCode, null, null);
	}

	public void initError(CODE errCode, String errMsg) {
		init(false, errCode, errMsg, null);
	}

	public void initError(String errMsg) {
		init(false, null, errMsg, null);
	}

	public void initError(CODE errCode, String errMsg, DATA data) {
		init(false, errCode, errMsg, data);
	}

	public void init(boolean success, CODE errCode, String errMsg, DATA data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
		this.success = success;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrMsg() {
		return this.errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public DATA getData() {
		return this.data;
	}

	public void setData(DATA user) {
		this.data = user;
	}

	public CODE getErrCode() {
		return this.errCode;
	}

	public void setErrCode(CODE errCode) {
		this.errCode = errCode;
	}

	public String toString() {
		return "ResultBean [success=" + this.success + ", errCode="
				+ this.errCode + ", errMsg=" + this.errMsg + ", data="
				+ this.data + "]";
	}

	public String getHelpMsg() {
		return this.helpMsg;
	}

	public void setHelpMsg(String helpMsg) {
		this.helpMsg = helpMsg;
	}
}
