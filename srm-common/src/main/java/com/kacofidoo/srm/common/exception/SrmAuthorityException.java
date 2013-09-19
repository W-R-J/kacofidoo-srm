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
public class SrmAuthorityException extends SrmException {

	private static final long serialVersionUID = 4366154752826156629L;

    public SrmAuthorityException() {
        super();
    }

    public SrmAuthorityException(String str) {
        super(str);
    }

    public SrmAuthorityException(Throwable e) {
        super(e);
    }

    public SrmAuthorityException(String str, Throwable e) {
        super(str, e);
    }


}
