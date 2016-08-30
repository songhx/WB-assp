package com.assp.common;


public class BizResult<T> extends ResultBean<ErrorType, T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BizResult() {
		super();
	}

	public BizResult(ErrorType errType, String errMsg) {
		super(errType, errMsg);
	}

	public BizResult(ErrorType errType) {
		super(errType);
	}

	public BizResult(T data) {
		super(data);
	}

	public ErrorType getErrType() {
		return getErrCode();
	}

	public void setErrType(ErrorType errType) {
		setErrCode(errType);
	}

	public BizResult(ErrorType errType, String errMsg, T data) {
		super(errType, errMsg, data);
	}

	@Override
	public String getErrMsg() {
		ErrorType errType = getErrType();
		String msg = super.getErrMsg();
		if (msg==null&&errType!=null) {
			msg = errType.getMsg();
		}
		return msg;
	}

	@Override
	public void setErrMsg(String errMsg) {
		super.setErrMsg(errMsg);
//		throw new AppException("调用的功能不支持，请改为调用setErrType方法。");
	}
	
	
	public static ErrorType getErrorTypeByString(Integer code){
		ErrorType et = ErrorType.INTERFACE_OK;
		switch (code) {
		case 0:
			et = ErrorType.INTERFACE_OK;
			break;
		case 999900000:
			et = ErrorType.INTERFACE_PARAMNULL;
			break;
		case 999900001:
			et = ErrorType.INTERFACE_RUNTIME;
			break;
		case 999900002:
			et = ErrorType.INTERFACE_ERRORURL;
			break;
		case 999900003:
			et = ErrorType.INTERFACE_IOEXCEPT;
			break;
		case 999900004:
			et = ErrorType.INTERFACE_DOCMENTEXCEPT;
			break;
		case 999900005:
			et = ErrorType.INTERFACE_NOTFINDURL;
			break;

		default:
			et = ErrorType.INTERFACE_OK;
			break;
		}
		return et;
	}

}
