package cdc.armada.noah.common.exception;

/**
 * 结果异常，会被 ExceptionHandler 捕捉并返回给前端
 *
 * @author lancf
 */

public class ApplicationException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String code;
	private String msg;

	public ApplicationException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
