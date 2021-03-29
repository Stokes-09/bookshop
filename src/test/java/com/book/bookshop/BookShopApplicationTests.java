package com.book.bookshop;

import com.book.bookshop.mapper.CartMapper;
import com.book.bookshop.service.BookService;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookShopApplicationTests {

    @Autowired
    private BookService bookService;
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void findBookList(){
        bookService.list().forEach(System.out::println);
    }
    @Test
    public void findCartList(){
        cartMapper.findCartListByUserId(1).forEach(System.out::println);
    }

}
