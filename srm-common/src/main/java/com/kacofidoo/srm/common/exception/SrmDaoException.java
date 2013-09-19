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
public class SrmDaoException extends SrmException {

	private static final long serialVersionUID = -6371273071162460911L;

    public SrmDaoException() {
        super();
    }

    public SrmDaoException(String str) {
        super(str);
    }

    public SrmDaoException(Throwable e) {
        super(e);
    }

    public SrmDaoException(String str, Throwable e) {
        super(str, e);
    }


}
