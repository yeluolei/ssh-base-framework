package org.chinasb.framework.core.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:resources/spring/applicationContext.xml" })
@TransactionConfiguration(defaultRollback = false)
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseTestTemplate {

}
