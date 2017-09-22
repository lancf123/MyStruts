package cdc.armada.noah.common.configurer;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Tomcat Config
 * 
 * @author
 *
 */
@Configuration
public class TomcatConfig implements TomcatConnectorCustomizer {

	@Bean
	public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory() {

		TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
		tomcatFactory.addConnectorCustomizers(this);
		return tomcatFactory;
	}

	@Override
	public void customize(Connector connector) {

		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		protocol.setPort(8088);
		// 设置最大连接数
		protocol.setMaxConnections(20000);
		// 设置最大线程数
		protocol.setMaxThreads(2000);
		protocol.setConnectionTimeout(30000);
	}

}