package com.bugli.bookshelfview.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Book {
    public Book() {
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" + "\n" +
                "description='" + description + '\'' + "\n" +
                ", bookName='" + bookName + '\'' + "\n" +
                ", author='" + author + '\'' + "\n" +
                ", category='" + category + '\'' + "\n" +
                ", keyword='" + keyword + '\'' + "\n" +
                ", chapterList=" + chapterList + "\n" +
                ", indexLink='" + indexLink + '\'' + "\n" +
                ", newChapter=" + Arrays.toString(newChapter) + "\n" +
                ", netImg='" + netImg + '\'' + "\n" +
                ", cacheLocPath='" + cacheLocPath + '\'' + "\n" +
                ", lastReadChapter=" + Arrays.toString(lastReadChapter) + "\n" +
                ", markChapter=" + Arrays.toString(markChapter) + "\n" +
                ", currentWebSite='" + currentWebSite + '\'' + "\n" +
                ", allWebSite=" + allWebSite + "\n" +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //简介
    String description;
    //书名
    String bookName;
    //作者
    String author;
    //分类
    String category;
    //关键词
    String keyword;
    //章节目录  章节名和链接
    Map<String, String> chapterList;
    //书主页地址
    String indexLink;
    //网络最新章节 章节名\更新时间\链接
    String[] newChapter = new String[3];
    //封面图片 网络地址
    String netImg;
    //书本地缓存目录 一般是书名为目录 重名+1，img.png main.txt
    String cacheLocPath;
    //上次阅读章节 章节名\文件指针
    String[] lastReadChapter = new String[2];
    //书签 章节名\文件指针
    String[] markChapter = new String[2];
    //来源网站
    String currentWebSite;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Map<String, String> getChapterList() {
        return chapterList;
    }

    public void setChapterList(Map<String, String> chapterList) {
        this.chapterList = chapterList;
    }

    public String getIndexLink() {
        return indexLink;
    }

    public void setIndexLink(String indexLink) {
        this.indexLink = indexLink;
    }

    public String[] getNewChapter() {
        return newChapter;
    }

    public void setNewChapter(String[] newChapter) {
        this.newChapter = newChapter;
    }

    public String getNetImg() {
        return netImg;
    }

    public void setNetImg(String netImg) {
        this.netImg = netImg;
    }

    public String getCacheLocPath() {
        return cacheLocPath;
    }

    public void setCacheLocPath(String cacheLocPath) {
        this.cacheLocPath = cacheLocPath;
    }

    public String[] getLastReadChapter() {
        return lastReadChapter;
    }

    public void setLastReadChapter(String[] lastReadChapter) {
        this.lastReadChapter = lastReadChapter;
    }

    public String[] getMarkChapter() {
        return markChapter;
    }

    public void setMarkChapter(String[] markChapter) {
        this.markChapter = markChapter;
    }

    public String getCurrentWebSite() {
        return currentWebSite;
    }

    public void setCurrentWebSite(String currentWebSite) {
        this.currentWebSite = currentWebSite;
    }

    public List<String> getAllWebSite() {
        if (allWebSite == null) {
            allWebSite = new ArrayList<>();
        }
        return allWebSite;
    }

    public void setAllWebSite(List<String> allWebSite) {
        this.allWebSite = allWebSite;
    }

    //所有来源
    List<String> allWebSite;
}
