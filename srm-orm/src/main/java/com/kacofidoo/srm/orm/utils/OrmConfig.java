/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.orm.utils;

import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kacofidoo.srm.common.exception.SrmRuntimeException;

/**
 * @author Jeff.Tsai
 * 
 */
public class OrmConfig {

	private static final Log log = LogFactory.getLog(OrmConfig.class);
	private static final int DEFAULT_CODE_YES = 1;
	private static final int DEFAULT_CODE_NO = 0;

	private static Configuration config = null;
	private static int CODE_YES;
	private static int CODE_NO;

	static {
		try {
			reload();
			CODE_NO = config.getInt("orm.code.no", DEFAULT_CODE_NO);
			CODE_YES = config.getInt("orm.code.yes", DEFAULT_CODE_YES);
		} catch (ConfigurationException e) {
			if (log.isErrorEnabled()) {
				log.error("init orm configuration ERROR: ", e);
			}
			throw new SrmRuntimeException("init orm configuration ERROR: ", e);
		}
	}

	public synchronized static final void reload() throws ConfigurationException {
		config = new PropertiesConfiguration(OrmConfig.class.getClassLoader().getResource("orm.cfg.properties"));
		if (log.isDebugEnabled()) {
			log.debug("reload orm configuration success!");
			for (Iterator<String> it = config.getKeys(); it.hasNext();) {
				String foo = it.next();
				log.debug(foo + " = " + config.getString(foo));
			}
		}
	}

	public static final Configuration getConfig() {
		return config;
	}

	public static final int getCodeYes() {
		return CODE_YES;
	}

	public static final int getCodeNo() {
		return CODE_NO;
	}

}
