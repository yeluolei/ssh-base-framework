package org.chinasb.framework.modules.demo;

import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.chinasb.framework.core.base.test.BaseTestTemplate;
import org.junit.Assert;
import org.junit.Test;

public class MemcachedUtilsTest extends BaseTestTemplate {
    
    @Resource
    private MemcachedClient memcachedClient;
    
    @Test
    public void testAdd() throws TimeoutException, InterruptedException, MemcachedException {
        memcachedClient.add("test", 0, "hello test.");
    }
    
    @Test
    public void testGet() throws TimeoutException, InterruptedException, MemcachedException {
       String str = memcachedClient.get("test");
       Assert.assertEquals(str, "hello test.");
    }
}
