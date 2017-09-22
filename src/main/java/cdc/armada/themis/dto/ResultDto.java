package cdc.armada.themis.dto;

/**
 * @author lancf
 * 
 */
public class ResultDto<T> {

	private String code;
	private String msg;
	private T data;

	public ResultDto() {
	}

	public ResultDto(String code, String msg, T data) {
		this(code, msg);
		this.data = data;
	}

	public ResultDto(String code, String msg) {
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

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
