package com.kacofidoo.srm.common.exception;

/**
 * Created with IntelliJ IDEA.
 * User: jeff
 * Date: 9/19/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class SrmValidationException extends SrmException{

    public SrmValidationException() {
        super();
    }

    public SrmValidationException(String str) {
        super(str);
    }

    public SrmValidationException(Throwable e) {
        super(e);
    }

    public SrmValidationException(String str, Throwable e) {
        super(str, e);
    }


}
