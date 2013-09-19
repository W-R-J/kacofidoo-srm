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
public class SrmIOException extends SrmException {

	private static final long serialVersionUID = 6191259582697055635L;
    public SrmIOException() {
        super();
    }

    public SrmIOException(String str) {
        super(str);
    }

    public SrmIOException(Throwable e) {
        super(e);
    }

    public SrmIOException(String str, Throwable e) {
        super(str, e);
    }


}
