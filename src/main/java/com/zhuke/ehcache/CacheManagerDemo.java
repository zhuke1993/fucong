package com.zhuke.ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by zhuke on 2015/10/23.
 */
public class CacheManagerDemo {
    public static void ehcache() {
        CacheManager manager = CacheManager.create("C:\\Users\\Administrator\\Documents\\fucong\\target\\classes\\ehcache.xml");
        manager.addCache("TEST_ID.TEST");
        Cache cid = manager.getCache("TEST_ID.TEST");
        cid.put(new Element(5120L, new Person("zhue", "zzz")));
    }

    public static void main(String[] args) {
        CacheManager manager = CacheManager.create("C:\\Users\\Administrator\\Documents\\fucong\\target\\classes\\ehcache.xml");
        Cache cid = manager.getCache("TEST_ID.TEST");
        Element e5120 = cid.get(new Long(5120));
        System.out.println(e5120);
    }
}
