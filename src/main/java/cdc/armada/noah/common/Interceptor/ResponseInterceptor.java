package cdc.armada.noah.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ResponseInterceptor
 * 
 * @author acc
 *
 */
public class ResponseInterceptor implements HandlerInterceptor {

	/**
	 * debugMode
	 */
	private boolean debugMode = true;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(HandlerExceptionResolver.class);

	/**
	 * preHandle
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @param handler
	 *            handler
	 * @return boolean
	 * @throws Exception
	 *             Exception
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 首先判断是否是Debug模式(全局)，如果否则使拦截器失效
		LOGGER.info("preHandle start");
		if (!this.debugMode) {
			return true;
		}

		// String servletPath = request.getServletPath();
		//
		// if (handler instanceof HandlerMethod) {
		// HandlerMethod method = (HandlerMethod) handler;
		// }

		LOGGER.info("preHandle end");
		return true;
	}

	/**
	 * postHandle
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @param handler
	 *            handler
	 * @param modelAndView
	 *            modelAndView
	 * @throws Exception
	 *             Exception
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOGGER.info("postHandle start");
		if (!this.debugMode) {
			return;
		}
		LOGGER.info("postHandle end");

	}

	/**
	 * afterCompletion
	 * 
	 * @param request
	 *            request
	 * @param response
	 *            response
	 * @param handler
	 *            handler
	 * @param ex
	 *            ex
	 * @throws Exception
	 *             Exception
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		LOGGER.info("afterCompletion start");
		if (ex instanceof HttpServerErrorException) {
			throw new Exception(ex);
		}
		if (!this.debugMode) {
			return;
		}
		LOGGER.info("afterCompletion end");
	}

	/**
	 * isDebugMode
	 * 
	 * @return debugMode
	 */
	public boolean isDebugMode() {
		return debugMode;
	}

	/**
	 * setDebugMode
	 * 
	 * @param debugMode
	 *            debugMode
	 */
	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}

}