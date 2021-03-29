package com.book.bookshop.entity;


import lombok.Data;

@Data
public class CartVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Integer count;
    private String bookName;
    private String img_url;
    private double new_price;

}
