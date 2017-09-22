package cdc.armada.noah.common.configurer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cdc.armada.noah.common.Interceptor.AuthInterceptor;
import cdc.armada.noah.common.Interceptor.ResponseInterceptor;

/**
 * Web Config
 * 
 * @author lancf
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 多个拦截器组成一个拦截器链
		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new ResponseInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600);
	}

	@Bean
	public Logger createLogger() {
		return LoggerFactory.getLogger(WebConfig.class);
	}
}