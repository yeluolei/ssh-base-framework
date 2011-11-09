package org.chinasb.framework.core.base.util;

import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.Search;

public class FrameworkUtils {
    
    public static ISearch paging(Integer maxResults, Integer page) {
        Search search = new Search();
        search.setMaxResults(maxResults);
        search.setPage(page);
        return search;
    }
}
