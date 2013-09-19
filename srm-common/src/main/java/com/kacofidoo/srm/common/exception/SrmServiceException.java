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
public class SrmServiceException extends SrmException {

	private static final long serialVersionUID = -5828127824777815898L;

    public SrmServiceException() {
        super();
    }

    public SrmServiceException(String str) {
        super(str);
    }

    public SrmServiceException(Throwable e) {
        super(e);
    }

    public SrmServiceException(String str, Throwable e) {
        super(str, e);
    }


}
