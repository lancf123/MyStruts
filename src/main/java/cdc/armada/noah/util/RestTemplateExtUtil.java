package cdc.armada.noah.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cdc.armada.noah.common.CommonConst;

/**
 * restTemplate 的包装类
 * 
 * @author acc
 *
 */
@Component
public class RestTemplateExtUtil {

	/**
	 * 用POST的形式从远程服务中取值
	 * 
	 * @param url
	 *            远程服务地址
	 * @param request
	 *            request
	 * @param responseType
	 *            返回的类型
	 * @param uriVariables
	 *            访问的参数
	 * @return 从服务中取得的值
	 */
	public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) {
		// rest
		RestTemplate restTemplate = new RestTemplate();
		// call
		T result = restTemplate.postForObject(url, request, responseType, uriVariables);
		// check
		doCheckResponse(result);
		return result;
	}

	/**
	 * doCheckResponse
	 * 
	 * @param result
	 *            result
	 */
	private <T> void doCheckResponse(T result) {
		JsonNode beCheckResult = null;
		ObjectMapper mapper = null;
		JsonFactory factory = null;
		JsonParser parser = null;

		if (result instanceof JsonNode) {
			beCheckResult = (JsonNode) result;
		} else if (result instanceof String) {
			// transform
			mapper = new ObjectMapper();
			factory = mapper.getFactory();
			try {
				parser = factory.createParser(result.toString());
				beCheckResult = mapper.readTree(parser);
			} catch (Exception e) {
				// Do nothing
				// beCheckResult = null;
			}
		}

		// check run
		if (beCheckResult != null) {
			doCheckResponse(beCheckResult);
		}
	}

	/**
	 * 检查返回值的状态
	 * 
	 * @param response
	 *            response
	 */
	private void doCheckResponse(JsonNode response) {
		JsonNode status = response.get(CommonConst.RESPONSE_FIELD_STATUS);
		if (status != null && status.asText().equals(CommonConst.HTTP_STATUS_ERROR)) {
			//throw new BusinessFailureException("Response check failed.");
		}
	}

	/**
	 * post for object with Text 为防止文字乱码
	 * 
	 * @param url
	 *            url
	 * @param request
	 *            request
	 * @param responseType
	 *            responseType
	 * @param uriVariables
	 *            uriVariables
	 * @return result
	 */
	public <T> T postForObjectWithText(String url, Object request, Class<T> responseType, Object... uriVariables) {

		// rest
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/html;charset=UTF-8"));
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> formEntity = new HttpEntity<String>(request.toString(), headers);
		// call
		T result = restTemplate.postForObject(url, formEntity, responseType, uriVariables);
		// check
		doCheckResponse(result);
		return result;
	}
}
