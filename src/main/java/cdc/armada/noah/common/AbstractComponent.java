package cdc.armada.noah.common;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Common service component function define
 *
 * @author lancf
 */
public abstract class AbstractComponent {

	@Autowired
	private Logger logger;

	/**
	 * @return the logger
	 */
	public Logger getLogger() {

		return logger;
	}

	/**
	 * get current time
	 *
	 * @return
	 */
	protected Timestamp getCurrentTimestamp() {

		return new Timestamp(System.currentTimeMillis());
	}

	public void setLogger(Logger logger) {

		this.logger = logger;
	}

}
