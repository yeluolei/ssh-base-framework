package org.chinasb.framework.modules.demo.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.chinasb.framework.core.base.action.BaseAction;
import org.chinasb.framework.modules.demo.model.Demo;
import org.chinasb.framework.modules.demo.service.DemoService;
import org.springframework.stereotype.Controller;

/**
 * @author ethan
 */
@Controller
public class DemoAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Resource
    private DemoService demoService;

    @Action(value = "/demoAction", results = { @Result(name = SUCCESS, location = "/manager/modules/demo/index.jsp") })
    @Override
    public String execute() {
        List<Demo> demoList = demoService.findAll();
        httpServletRequest.setAttribute("DEMO_LIST", demoList);
        return SUCCESS;
    }

    @Action(value = "/demoAddAction", results = { @Result(name = SUCCESS, location = "/demoAction", type = "redirect") })
    public String add() {
        Demo demo = new Demo();
        demo.setTitle(httpServletRequest.getParameter("title"));
        demo.setContent(httpServletRequest.getParameter("content"));
        demo.setPublishdate(new Date());
        demoService.save(demo);
        return SUCCESS;
    }

    @Action(value = "/demoDeleteAction", results = { @Result(name = SUCCESS, location = "/demoAction", type = "redirect") })
    public String delete() {
        demoService.removeById(Integer.parseInt(httpServletRequest.getParameter("id")));
        return SUCCESS;
    }
}
