package com.bugli.bookshelfview.utils;

import android.util.Log;

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
     * 这里应该只返回书名和书主页地址，避免耗时太长
     * 重名的书籍，添加链接到对应书籍
     */
    public static List<Book> getAllBooksFromAllWebSites() {
        List<Book> books = new ArrayList<>();

        for (String siteName : WebSites.getInstance().websiteList.keySet()) {

            List<Book> bks = getAllBooksFromWebSite(siteName);
            //
            books.addAll(bks);
        }
        Log.d("bugli", books.size() + "");
        return books;
    }

    /**
     * 从某网站获取所有书籍
     * 这里应该只返回书名和书主页地址，避免耗时太长
     */
    public static List<Book> getAllBooksFromWebSite(final String siteName) {
        final List<Book> books = new ArrayList<>();
        final String currentSite = WebSites.getInstance().websiteList.get(siteName);
        switch (siteName) {
            case "新笔趣阁": {
                Log.d("bugli", "=> 新笔趣阁" + currentSite);
                String s = HttpRequestUtil.doGet(currentSite + "/xiaoshuodaquan", "UTF-8");
                Document doc = Jsoup.parse(s);
                Elements lists = doc.getElementsByClass("novellist");
                for (Element item : lists) {
                    Elements novelList = item.getElementsByTag("li");
                    for (final Element e : novelList) {
                        String href = e.getElementsByTag("a").get(0).attr("href");
                        String bookName = e.text();
                        Book book = new Book();
                        //设置阅读主页和来源网址
                        book.setBookName(bookName);
                        book.setIndexLink(href);
                        book.setCurrentWebSite(currentSite);
                        book.getAllWebSite().add(siteName);
                        books.add(book);
                    }
                }
                break;
            }
            case "书荒阁": {
                Log.d("bugli", "=> 书荒阁" + currentSite);
                String s = HttpRequestUtil.doGet(currentSite + "/xiaoshuodaquan", "GBK");
                Document doc = Jsoup.parse(s);
                Elements lists = doc.getElementsByClass("novellist");
                for (Element item : lists) {
                    Elements novelList = item.getElementsByTag("li");
                    for (final Element e : novelList) {
                        String href = e.getElementsByTag("a").get(0).attr("href");
                        String bookName = e.text();
                        Book book = new Book();
                        //设置阅读主页和来源网址
                        book.setBookName(bookName);
                        book.setIndexLink(href);
                        book.setCurrentWebSite(currentSite);
                        book.getAllWebSite().add(siteName);
                        books.add(book);
                    }
                }
                break;
            }
            case "红叶书斋": {
                Log.d("bugli", "=> 红叶书斋" + currentSite);
                String s = HttpRequestUtil.doGet(currentSite + "/xiaoshuodaquan", "GBK");
                Document doc = Jsoup.parse(s);
                Elements lists = doc.getElementsByClass("novellist");
                for (Element item : lists) {
                    Elements novelList = item.getElementsByTag("li");
                    for (final Element e : novelList) {
                        String href = e.getElementsByTag("a").get(0).attr("href");
                        String bookName = e.text();
                        Book book = new Book();
                        //设置阅读主页和来源网址
                        book.setBookName(bookName);
                        book.setIndexLink(href);
                        book.setCurrentWebSite(currentSite);
                        book.getAllWebSite().add(siteName);
                        books.add(book);
                    }
                }
                break;
            }
            default:
                break;
        }
        return books;
    }


    /**
     * 从某网站获取指定名称书籍
     * 获取详细信息
     */
    public static Book getBookFromWebSite(String bookName, String siteName) {
        Book book = new Book();

        return book;
    }


    /**
     * 根据链接获取书籍
     * 获取详细信息
     */
    public static Book getBookByLink(String link, String webSite) {
        String mainLink = WebSites.getInstance().websiteList.get(webSite);
        Book book = new Book();
        switch (webSite) {
            case "新笔趣阁": {
                String s = HttpRequestUtil.doGet(link, "UTF-8");
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
                break;
            }
            case "书荒阁":

            case "红叶书斋":


            default:
                break;
        }

        return book;
    }

}
