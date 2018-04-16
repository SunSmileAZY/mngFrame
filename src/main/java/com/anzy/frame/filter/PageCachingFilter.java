package com.anzy.frame.filter;

import com.anzy.frame.utils.SpringContextHolder;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;
/**
 * 页面高速缓存过滤器
 * Created by anzy on 2018/3/9.
 */
public class PageCachingFilter extends SimplePageCachingFilter {

    private CacheManager cacheManager = SpringContextHolder.getBean(CacheManager.class);

    @Override
    protected CacheManager getCacheManager() {
        return cacheManager;
    }

}
