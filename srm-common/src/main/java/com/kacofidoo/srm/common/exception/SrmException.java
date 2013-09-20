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
public class SrmException extends Exception {

    protected int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    private static final long serialVersionUID = 4560648894965065095L;

	public SrmException() {
		super();
	}

	public SrmException(String str) {
		super(str);
	}

	public SrmException(Throwable e) {
		super(e);
	}

	public SrmException(String str, Throwable e) {
		super(str, e);
	}

}
