package com.bugli.bookshelfview.utils;

import com.bugli.bookshelfview.bean.Book;
import com.bugli.bookshelfview.comon.WebSites;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PYBookUtil {

    /**
     * 从所有的网站获取所有书籍
     * 重名的书籍，添加链接到对应书籍，不重复导
     */
    public static List<Book> getAllBooksFromAllWebSites() {
        List<Book> books = new ArrayList<>();

        for (String siteName : WebSites.getInstance().websiteList.keySet()) {
            List<Book> bks = getAllBooksFromWebSite(siteName);
            //
        }
        return books;
    }

    /**
     * 从某网站获取所有书籍
     */
    public static List<Book> getAllBooksFromWebSite(String siteName) {
        List<Book> books = new ArrayList<>();
        switch (siteName) {
            case "新笔趣阁":
                String currentSite = WebSites.getInstance().websiteList.get(siteName);
                String s = HttpRequestUtil.doGet(currentSite + "/xiaoshuodaquan");
                Document doc = Jsoup.parse(s);
                Elements lists = doc.getElementsByClass("novellist");
                Elements novellist = lists.get(0).getElementsByTag("li");
                for (Element e : novellist) {
                    String href = e.getElementsByTag("a").get(0).attr("href");
                    String bookName = e.text();
                    //根据链接获取书籍的详细信息
                    Book book = getBookByLink(href, currentSite);
                    books.add(book);
                    //设置阅读主页和来源网址
                    book.setBookName(bookName);
                    book.setIndexLink(href);
                    book.setCurrentWebSite(currentSite);
                    books.add(book);
                }
            default:
                break;
        }

        return books;

    }


    /**
     * 从某网站获取指定名称书籍
     */
    public static Book getBookFromWebSite(String bookName, String siteName) {
        Book book = new Book();

        return book;
    }


    /**
     * 根据链接获取书籍
     */
    public static Book getBookByLink(String link, String mainLink) {
        Book book = new Book();
        String s = HttpRequestUtil.doGet(link);
        Document doc = Jsoup.parse(s);
        Elements metas = doc.getElementsByTag("meta");
        for (Element e : metas) {
            if (e.attr("property").equalsIgnoreCase("og:description")) {
                String description = e.attr("content");
                //简介
                book.setDescription(description);
            } else if (e.attr("property").equalsIgnoreCase("og:image")) {
                String image = e.attr("content");
                //图片
                book.setNetImg(image);
            } else if (e.attr("property").equalsIgnoreCase("og:novel:category")) {
                String category = e.attr("content");
                //分类
                book.setCategory(category);
            } else if (e.attr("property").equalsIgnoreCase("og:novel:author")) {
                String author = e.attr("content");
                //作者
                book.setAuthor(author);
            }
        }

        Elements ps = doc.getElementsByTag("p");
        String newChapterName = "";
        String newChapterTime = "";
        String newChapterLink = "";
        for (Element e : ps) {
            if (!newChapterLink.isEmpty() && !newChapterName.isEmpty() && !newChapterTime.isEmpty()) {
                break;
            }
            if (e.outerHtml().contains("最新章节")) {
                Elements as = e.getElementsByTag("a");
                newChapterLink = as.get(0).attr("href");
                newChapterName = as.get(0).text();
            } else if (e.outerHtml().contains("最后更新")) {
                newChapterTime = e.text();
            }
        }
        //最新章节
        book.setNewChapter(new String[]{newChapterName, newChapterTime, newChapterLink});
        //有序map
        Map<String, String> chapterList = new LinkedHashMap<>();
        Elements dds = doc.getElementsByTag("dd");
        for (Element e : dds) {
            String chapterLink = mainLink + e.getElementsByTag("a").get(0).attr("href");
            String chapterName = e.text();
            chapterList.put(chapterName, chapterLink);
        }
        //章节列表
        book.setChapterList(chapterList);
        return book;
    }

}
