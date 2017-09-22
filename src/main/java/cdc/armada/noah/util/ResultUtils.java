package cdc.armada.noah.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import cdc.armada.noah.common.CommonConst;
import cdc.armada.themis.dto.ResultDto;

/**
 * @author lancf
 */
@Component
public class ResultUtils {

	@Autowired
	private Environment env;

	public ResultDto<Object> success(Object data) {
		return new ResultDto<Object>(CommonConst.SUCCESS_CODE, env.getProperty(CommonConst.SUCCESS_CODE), data);
	}
	
	public ResultDto<Object> success() {
		return new ResultDto<Object>(CommonConst.SUCCESS_CODE, env.getProperty(CommonConst.SUCCESS_CODE));
	}

	public ResultDto<Object> warn(String code, String msg) {
		return new ResultDto<Object>(code, msg);
	}

}
