package cdc.armada.noah.common.advice;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cdc.armada.noah.common.AbstractComponent;
import cdc.armada.noah.common.CommonConst;
import cdc.armada.noah.common.exception.ApplicationException;
import cdc.armada.noah.util.ResultUtils;
import cdc.armada.themis.dto.ResultDto;

/**
 * @author lancf
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice extends AbstractComponent {

	@Autowired
	private Environment env;

	@Autowired
	private ResultUtils resultUtils;

	@ExceptionHandler(ApplicationException.class)
	public ResultDto<Object> handleResultException(ApplicationException e, HttpServletRequest request) {
		getLogger().error(e.getMsg());
		return resultUtils.warn(e.getCode(), e.getMsg());
	}

	@ExceptionHandler(Exception.class)
	public ResultDto<Object> handleException(Exception e, HttpServletRequest request) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String msg = sw.toString();
		getLogger().error(msg);
		return resultUtils.warn(CommonConst.SYSTEM_ERROR_CODE, env.getProperty(CommonConst.SYSTEM_ERROR_CODE));
	}
}
