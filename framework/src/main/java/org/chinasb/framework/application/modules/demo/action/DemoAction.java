package org.chinasb.framework.application.modules.demo.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.chinasb.framework.application.modules.demo.model.Demo;
import org.chinasb.framework.application.modules.demo.service.DemoService;
import org.springframework.stereotype.Controller;

import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ethan
 */
@ParentPackage("json-default")
@Controller
public class DemoAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	@Resource
	private DemoService demoService;

	private Integer id;

	private String title;

	private String content;

	private String oper;
	
	protected Map<String, Object> session;

	// Your result List
	private List<Demo> gridModel;

	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord;

	// get index row - i.e. user click to sort.
	private String sidx;

	// Search Field
	private String searchField;

	// The Search String
	private String searchString;

	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String searchOper;

	// Your Total Pages
	private Integer total = 0;

	// All Record
	private Integer records = 0;

	public List<Demo> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<Demo> gridModel) {
		this.gridModel = gridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	@JSON(serialize = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JSON(serialize = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JSON(serialize = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JSON(serialize = false)
	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Action(value = "demoAction", results = { @Result(name = SUCCESS, type = "json") })
	@Override
	public String execute() {
		Search search = new Search();
		search.setMaxResults(this.rows);
		search.setPage(this.page - 1);
		SearchResult<Demo> result = demoService.searchAndCount(search);
		this.records = result.getTotalCount();
		this.gridModel = result.getResult();
		this.total = (int) Math.ceil((double) records / (double) rows);
		return SUCCESS;
	}

	@Action(value = "demoEditAction", results = { @Result(name = SUCCESS, type = "json") })
	public String edit() {
		if (this.oper == "add") {
			Demo demo = new Demo();
			demo.setTitle(this.title);
			demo.setContent(this.content);
			demo.setPublishdate(new Date());
			demoService.save(demo);
		} else {
			Demo demo = demoService.findById(this.id);
			demo.setTitle(this.title);
			demo.setContent(this.content);
			demoService.save(demo);
		}
		return SUCCESS;
	}
}
