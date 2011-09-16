package org.chinasb.framework.modules.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.chinasb.framework.modules.demo.dao.DemoDao;
import org.chinasb.framework.modules.demo.model.Demo;
import org.chinasb.framework.modules.demo.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ethan
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DemoServiceImpl implements DemoService {
	@Resource
	private DemoDao demoDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Demo demo) {
		return demoDao.save(demo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Demo[] demos) {
		return demoDao.save(demos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Demo demo) {
		return demoDao.remove(demo);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Demo[] demos) {
		demoDao.remove(demos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(Integer id) {
		return demoDao.removeById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void removeByIds(Integer[] ids) {
		demoDao.removeByIds(ids);
	}

	@Override
	public List<Demo> findAll() {
		return demoDao.findAll();
	}

	@Override
	public Demo findById(Integer id) {
		return demoDao.find(id);
	}

	@Override
	public Demo[] findByIds(Integer[] ids) {
		return demoDao.find(ids);
	}

	@Override
	public void flush() {
		demoDao.flush();
	}
}
