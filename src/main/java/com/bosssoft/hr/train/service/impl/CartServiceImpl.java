package com.bosssoft.hr.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.hr.train.entity.Cart;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.mapper.CartMapper;
import com.bosssoft.hr.train.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bosssoft.hr.train.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author misheep
 * @since 2020-07-12
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    private HttpSession session;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private CartMapper cartMapper;

    private HashMap<Long, Goods> myCart;
    private long userUid;
    private float totalPrice=0;

    @Override
    public boolean add(Goods goods) {
        getCart();
        if(goods==null) {
            return false;
        }
        myCart.put(goods.getGoodsUID(), goods);
        totalPrice += goods.getPrice() * goods.getNumber();
        return false;
    }

    @Override
    public boolean remove(long goodsUid) {
        getCart();
        Goods goods = myCart.get(goodsUid);
        totalPrice -= goods.getPrice() * goods.getNumber();
        myCart.remove(goodsUid);
        return true;
    }

    @Override
    public boolean edit(long goodsUid, int number) {
        getCart();
        if(!myCart.containsKey(goodsUid)) {
            return false;
        }
        if(number<0) {
            return false;
        }else if(number==0){
            myCart.remove(goodsUid);
        }else{
        Goods goods = myCart.get(goodsUid);
        totalPrice += (number - goods.getNumber()) * goods.getPrice();
        goods.setNumber(number);
        }
        return true;
    }

    @Override
    public String getJSONString() {
        getCart();
        return JSONObject.toJSONString(myCart.entrySet().toArray());
    }

    @Override
    public String settle() {
        Cart cart = new Cart();
        cart.setUserUID(userUid);
        cart.setTotalPrice(totalPrice);
        cartMapper.insert(cart);
        orderInfoService.settle(cart.getCartUID());
        return null;
    }

    @Override
    public long getOwnerId() {
        userUid = 2020;
        return userUid;
    }

    @Override
    public HashMap<Long, Goods> getCart() {
        myCart = (HashMap) session.getAttribute("myCart");
        if(myCart == null){
            myCart = new HashMap<>();
            session.setAttribute("myCart",myCart);
        }
        return myCart;
    }
}
