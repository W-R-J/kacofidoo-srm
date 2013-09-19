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
public class SrmControllerException extends SrmException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 197392935819005766L;

    public SrmControllerException() {
        super();
    }

    public SrmControllerException(String str) {
        super(str);
    }

    public SrmControllerException(Throwable e) {
        super(e);
    }

    public SrmControllerException(String str, Throwable e) {
        super(str, e);
    }


}
