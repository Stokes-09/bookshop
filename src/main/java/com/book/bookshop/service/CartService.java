package com.book.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.Cart;
import com.book.bookshop.entity.CartVo;
import com.book.bookshop.entity.UserCartVo;
import com.book.bookshop.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
    @Autowired
    private CartMapper cartMapper;
    //根据用户查询购物车记录
    public List<CartVo> findCartByUser(Integer userId){
        return cartMapper.findCartListByUserId(userId);
    }

    //购物车ID查询对应的记录
    public List<CartVo> findCartById(String ids){
        return cartMapper.findCartListByIds(Arrays.asList(ids));
    }
    /**
     * 统计当前购物车的统计
     */
    public double getCartItemTotal(List<CartVo> list){
        double sum = 0.0;
        for (CartVo cart:list) {
            sum += cart.getCount()*cart.getNew_price();
        }
        return sum;
    }

    /*
    批量删除
     */
    public String batchDelete(String ids) {
        if (ids != null){
            String[] idArray = ids.split(",");
            cartMapper.deleteBatchIds(Arrays.asList(idArray));
         }
        return "success";
    }

    /*
    包装购物车用户信息数据
     */
    public UserCartVo wrapperCart(List<CartVo> list){
        UserCartVo userCartVo = new UserCartVo();
        userCartVo.setNum(list.size());
        userCartVo.setTotalPrice(getCartItemTotal(list));
        return userCartVo;
    }
}
