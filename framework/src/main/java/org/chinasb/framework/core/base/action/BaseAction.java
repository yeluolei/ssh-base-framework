package org.chinasb.framework.core.base.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.chinasb.framework.core.base.model.BaseModel;

import com.opensymphony.xwork2.ActionSupport;

/**
 * base action
 * 
 * @author ethan
 */
public class BaseAction extends ActionSupport implements ServletContextAware, ServletResponseAware, ServletRequestAware, SessionAware {

    private static final long serialVersionUID = 1L;

    private BaseModel returnModel;

    protected ServletContext servletContext;

    protected HttpServletRequest httpServletRequest;

    protected HttpServletResponse httpServletResponse;

    protected HttpSession httpSession;

    protected Map<String, Object> session;

    public BaseModel getReturnModel() {
        return returnModel;
    }

    public void setReturnModel(BaseModel returnModel) {
        this.returnModel = returnModel;
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.servletContext = context;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.httpServletResponse = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
        this.httpSession = request.getSession();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void returnModel(Object data) {
        returnModel = new BaseModel();
        returnModel.setData(data);
    }
    
    public void returnModel(Object data, boolean returnState) {
        returnModel = new BaseModel();
        returnModel.setData(data);
        returnModel.setReturnState(returnState);
    }
}
