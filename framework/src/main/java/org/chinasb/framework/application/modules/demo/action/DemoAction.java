package org.chinasb.framework.application.modules.demo.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.chinasb.framework.core.base.action.BaseAction;
import org.chinasb.framework.core.base.model.GridModel;
import org.chinasb.framework.core.base.util.FrameworkUtils;
import org.chinasb.framework.application.modules.demo.model.Demo;
import org.chinasb.framework.application.modules.demo.service.DemoService;
import org.springframework.stereotype.Controller;

import com.googlecode.genericdao.search.SearchResult;

/**
 * @author ethan
 */
@ParentPackage("json-default")
@Controller
public class DemoAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Resource
    private DemoService demoService;
    
    private GridModel gridModel;

    @JSON(serialize=false)
    public GridModel getGridModel() {
        return gridModel;
    }

    public void setGridModel(GridModel gridModel) {
        this.gridModel = gridModel;
    }

    @Action(value = "demoAction", results = { @Result(name = SUCCESS, type = "json", params={"root","returnModel"}) })
    @Override
    public String execute() {
        gridModel = new GridModel();
        SearchResult<Demo> result = demoService.searchAndCount(FrameworkUtils.paging(gridModel.getRows(), gridModel.getPage()));
        gridModel.setRecords(result.getTotalCount());
        gridModel.setGridModel(result.getResult());
        returnModel(gridModel);
        return SUCCESS;
    }
}
