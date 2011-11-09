package org.chinasb.framework.application.modules.demo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.chinasb.framework.core.base.action.BaseAction;
import org.chinasb.framework.application.modules.demo.model.Demo;
import org.chinasb.framework.application.modules.demo.service.DemoService;
import org.springframework.stereotype.Controller;

@ParentPackage("json-default")
@Controller
public class DemoJsonListAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Resource
    private DemoService demoService;

    private List<Demo> demoList = new ArrayList<Demo>();

    public List<Demo> getDemoList() {
        return demoList;
    }

    public void setDemoList(List<Demo> demoList) {
        this.demoList = demoList;
    }

    @Action(value = "demoJsonListAction", results = { @Result(name = SUCCESS, type = "json", params={"root","demoList"}) })
    @Override
    public String execute() {
        this.demoList = demoService.findAll();
        return SUCCESS;
    }
}
