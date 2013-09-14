/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.console.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

/**
 * 全局session上下文
 * 
 * @author Jeff.Tsai
 * 
 */
public final class SessionContext {

	private static SessionContext INSTANCE;

	private Map<String, HttpSession> sessionMap;

	private SessionContext() {
		this.sessionMap = new ConcurrentHashMap<String, HttpSession>();
	}

	static {
		synchronized (SessionContext.class) {
			if (INSTANCE == null) {
				INSTANCE = new SessionContext();
			}
		}
	}

	public static final SessionContext getInstance() {
		return INSTANCE;
	}

	public HttpSession get(final String sessionId) {
		return this.sessionMap.get(sessionId);
	}

	public boolean contains(final String sessionId) {
		return this.sessionMap.containsKey(sessionId);
	}

	public HttpSession remove(final String sessionId) {
		return this.sessionMap.remove(sessionId);
	}

	public void put(final HttpSession session) {
		this.sessionMap.put(session.getId(), session);
	}

	public Map<String, HttpSession> getSessionMap() {
		return this.sessionMap;
	}

}
