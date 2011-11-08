package org.chinasb.framework.core.base.util;

import net.rubyeye.xmemcached.MemcachedClient;

/**
 * @author ethan
 */
public class MemcachedUtils {

    private MemcachedClient memcachedClient;
    
    private static MemcachedUtils memcachedUtils;

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    public void init() {
        memcachedUtils = this;
        memcachedUtils.memcachedClient = this.memcachedClient;
    }
    
    public static MemcachedClient getInstance() {
         return memcachedUtils.memcachedClient;
    }
}
