package com.book.bookshop.entity.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Category {
    SELECTED(1,"精选图书"),RECOMMEND(2,"热销图书"),BARGAIN(3,"甩卖图书");

    Category(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    @EnumValue//标记数据库存的是code
    private final int code;
    private final String desc;
}
