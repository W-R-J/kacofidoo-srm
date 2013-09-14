/**
 * Developed by Jeff.Tsai
 * Shanghai, China
 * Email: jjeffcaii@outlook.com
 */
package com.kacofidoo.srm.common.exception;

/**
 * @author Jeff.Tsai
 * 
 */
public class SrmRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 5273810840417923499L;

	public SrmRuntimeException() {
		super();
	}

	public SrmRuntimeException(String str, Throwable e) {
		super(str, e);
	}

	public SrmRuntimeException(Throwable e) {
		super(e);
	}

	public SrmRuntimeException(String str) {
		super(str);
	}

}
