package com.bugli.bookshelfview.network;

import com.bugli.bookshelfview.bean.Book;

import java.util.ArrayList;
import java.util.List;

class BookNetwork {
    //从某个网站获取所有的书籍
    public static List<Book> getAllFromSite() {
        List<Book> books = new ArrayList<>();

        return books;
    }

    //去每个网站查询该书籍
    public static Book getBookFromAllSites(String name) {
        Book book = new Book();

        return book;
    }
}
