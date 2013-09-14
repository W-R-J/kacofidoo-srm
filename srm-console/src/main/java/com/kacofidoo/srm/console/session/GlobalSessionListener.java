/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 全局session监听器
 * 
 * @author Jeff.Tsai
 * 
 */
public class GlobalSessionListener implements HttpSessionListener {

	private static final Log log = LogFactory.getLog(GlobalSessionListener.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		final HttpSession session = event.getSession();
		SessionContext.getInstance().put(session);
		if (log.isDebugEnabled()) {
			log.debug("session " + session.getId() + " enter.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		final String sessionId = event.getSession().getId();
		SessionContext.getInstance().remove(sessionId);
		if (log.isDebugEnabled()) {
			log.debug("session " + sessionId + " leave.");
		}
	}

}
