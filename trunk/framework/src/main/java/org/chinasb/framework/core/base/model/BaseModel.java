package org.chinasb.framework.core.base.model;

public class BaseModel {
    
    private Object data;
    private boolean returnState = true;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isReturnState() {
        return returnState;
    }

    public void setReturnState(boolean returnState) {
        this.returnState = returnState;
    }

}
