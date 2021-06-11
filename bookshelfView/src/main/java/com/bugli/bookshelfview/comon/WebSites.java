package com.bugli.bookshelfview.comon;

import java.util.HashMap;
import java.util.Map;

public class WebSites {
    public Map<String, String> websiteList = new HashMap<>();
    private volatile static WebSites instance = null;

    //初始化列表
    WebSites() {
        websiteList.put("新笔趣阁", "https://www.xbiquge.la");
    }


    public void clearWebSite() {
        websiteList.clear();
    }

    public void addWebSite(String siteName, String siteLink) {
        websiteList.put(siteName, siteLink);
    }

    public void removeWebSite(String siteName) {
        websiteList.remove(siteName);
    }

    public static WebSites getInstance() {
        if (instance == null) {
            synchronized (WebSites.class) {
                if (instance == null) {
                    instance = new WebSites();
                }
            }
        }
        return instance;
    }
}
