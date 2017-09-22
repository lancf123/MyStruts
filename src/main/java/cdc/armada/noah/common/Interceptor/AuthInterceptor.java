package cdc.armada.noah.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 权限管理拦截器
 * 
 * @author chen
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

//	/**
//	 * LOGGER
//	 */
//	private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

	@Autowired
	HttpSession httpSession;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		LOGGER.info("AuthInterceptor validate");
//
//		if (!(handler instanceof HandlerMethod)) {
//			return true;
//		}
//
//		// 处理Permission Annotation，实现方法级权限控制
//		HandlerMethod method = (HandlerMethod) handler;
//		Passport passport = method.getMethodAnnotation(Passport.class);
//
//		// 如果为空在表示该方法不需要进行权限验证
//		if (passport == null) {
//			return true;
//		}
//
//		// 权限check
//		if (passport.authorityCheck()) {
//			// 查询Session，确认是否有用户登陆
//			if (isNotLogin(request)) {
//				if (isAjaxRequest(request)) {
//					// Ajax请求的时候返回Json
//					JSONObject jsonobject = new JSONObject();
//					jsonobject.put("status", "success");
//					jsonobject.put("result", "AuthorityCheckFailed");
//					jsonobject.put("errors", "Have no authority.");
//
//					ObjectMapper mapper = new ObjectMapper();
//					PrintWriter writer = response.getWriter();
//					writer.write(mapper.readTree(jsonobject.toString()).toString());
//
//				} else {
//					// 普通Submit
//					PrintWriter writer = response.getWriter();
//					String script = "<script>window.open(\"\",\"_top\").close()</script>";
//					writer.write(script);
//				}
//			}
//
//			// 验证失败返回登陆画面
//			return false;
//		}

		// 验证成功正常返回
		return true;
	}

	// private boolean isAjaxRequest(HttpServletRequest request) {
	// return !StringUtils.isEmpty(request.getHeader("x-requested-with"));
	//
	// }
	//
	// private boolean isNotLogin(HttpServletRequest request) {
	// return request.getSession().getAttribute("userid") == null;
	// }
}