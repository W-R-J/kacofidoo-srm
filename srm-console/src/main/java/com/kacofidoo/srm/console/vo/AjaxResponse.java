package com.kacofidoo.srm.console.vo;

import com.kacofidoo.srm.common.utils.JsonUtils;

/**
 * Created with IntelliJ IDEA.
 * User: jeff
 * Date: 9/19/13
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class AjaxResponse {

    public static final AjaxResponse success(){
        return success("");
    }
    public static final AjaxResponse success(Object content){
        return create(true,content);
    }

    private static final AjaxResponse create(boolean success,Object content){
        AjaxResponse foo = new AjaxResponse();
        foo.setSuccess(success);
        foo.setContent(content);
        return foo;
    }

    public static final AjaxResponse failed(){
        return failed("");
    }

    public static final AjaxResponse failed(Object content){
        return create(false,content);
    }


    private boolean success;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private Object content;

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
