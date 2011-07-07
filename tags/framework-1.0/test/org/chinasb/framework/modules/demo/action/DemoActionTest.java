package org.chinasb.framework.modules.demo.action;

import java.util.Date;

import javax.annotation.Resource;

import org.chinasb.framework.core.base.test.BaseTestTemplate;
import org.chinasb.framework.modules.demo.model.Demo;
import org.chinasb.framework.modules.demo.service.DemoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

public class DemoActionTest extends BaseTestTemplate {

    @Resource
    private DemoService demoService;

    @Before
    public void setUp() throws Exception {
	System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
	System.out.println("测试结束");
    }

    @BeforeTransaction
    public void beforeTransaction() {
	System.out.println("事务开始");
    }

    @AfterTransaction
    public void afterTransaction() {
	System.out.println("事务结束");
    }

    @Test
    public void testInsert() {
	Demo demo = new Demo();
	demo.setTitle("junit-test");
	demo.setContent("junit-content");
	demo.setPublishdate(new Date());
	demoService.save(demo);
    }

    @Test
    public void testInsertMore() {
	Demo[] demos = new Demo[10];
	for (int i = 0; i < 10; i++) {
	    Demo demo = new Demo();
	    demo.setTitle("junit-test" + i);
	    demo.setContent("junit-content" + i);
	    demo.setPublishdate(new Date());
	    demos[i] = demo;
	}
	demoService.save(demos);
    }
}
