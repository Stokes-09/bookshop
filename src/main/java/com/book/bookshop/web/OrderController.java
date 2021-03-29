package com.book.bookshop.web;


import com.book.bookshop.entity.CartVo;
import com.book.bookshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CartService cartService;
    /*
    确认订单
     */
    @RequestMapping("/confirm")
    public String confirm(String ids, Model model){
        //查询记录
        List<CartVo> cartVos = cartService.findCartById(ids);
        model.addAttribute("list",cartVos);
        return "confirm_order";

    }
}
