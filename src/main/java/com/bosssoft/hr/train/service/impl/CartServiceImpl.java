package com.bosssoft.hr.train.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bosssoft.hr.train.entity.Cart;
import com.bosssoft.hr.train.entity.Goods;
import com.bosssoft.hr.train.mapper.CartMapper;
import com.bosssoft.hr.train.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bosssoft.hr.train.service.GoodsService;
import com.bosssoft.hr.train.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * <p>
 * 购物车
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
    private GoodsService goodsService;
    @Autowired
    private CartMapper cartMapper;
    //当前购物车内的商品列表，key=GoodsUid(商品主键),value=(商品类)
    private HashMap<Long, Goods> myCart;
    //用户UID
    private long userUid;
    //当前购物车内商品的总价（也可删除，前端计算后在前端展示，后端在settle结算时计算并写入数据库）
    private float totalPrice = 0;

    //购物车中新增商品
    @Override
    public boolean add(Goods goods) {
        getCart();
        //判断该商品是否存在于店家商品清单中
        if (!goodsService.findGoods(goods)) {
            return false;
        }
        //购物车中新增该商品
        myCart.put(goods.getGoodsUID(), goods);
        //计算总价
        totalPrice += goods.getPrice() * goods.getNumber();
        //测试，即展示用，提交时可将print语句删除
        System.out.println("session myCart size(after):" + myCart.size());
        System.out.println(JSONObject.toJSONString(myCart.entrySet().toArray()));
        return true;
    }

    //删除商品
    @Override
    public boolean remove(long goodsUid) {
        getCart();
        //判断要删除的商品是否存在购物车中
        if (!myCart.containsKey(goodsUid)) {
            return false;
        }
        Goods goods = myCart.get(goodsUid);
        //判断商品是否存在店家商品清单中
        if (!goodsService.findGoods(goods)) {
            return false;
        }
        //计算总价，并在购物车中删除该商品
        totalPrice -= goods.getPrice() * goods.getNumber();
        myCart.remove(goodsUid);
        //测试，即展示用，提交时可将print语句删除
        System.out.println("session myCart size(after):" + myCart.size());
        System.out.println(JSONObject.toJSONString(myCart.entrySet().toArray()));
        return true;
    }

    //修改商品购买数量
    @Override
    public boolean edit(long goodsUid, int number) {
        getCart();
        //判断要修改数量的商品是否存在购物车中
        if (!myCart.containsKey(goodsUid)) {
            return false;
        }
        Goods goods = myCart.get(goodsUid);
        //判断该商品是否存在于店家商品清单中
        if (!goodsService.findGoods(goods)) {
            return false;
        }
        if (number < 0) {
            return false;
        } else if (number == 0) {
            //若修改后的商品数量等于0，则认为要删除该商品
            remove(goodsUid);
        } else {
            //计算总价，并修改购物车中该商品的数量
            totalPrice += (number - goods.getNumber()) * goods.getPrice();
            goods.setNumber(number);
        }
        //测试，即展示用，提交时可将print语句删除
        System.out.println("session myCart size(after):" + myCart.size());
        System.out.println(JSONObject.toJSONString(myCart.entrySet().toArray()));
        return true;
    }

    //以JSONString形式返回购物车内商品清单信息
    @Override
    public String getJSONString() {
        getCart();
        return JSONObject.toJSONString(myCart.entrySet().toArray());
    }

    //提交购物车，即结算
    @Override
    public String settle() {
        Cart cart = new Cart();
        cart.setUserUID(getOwnerId());
        cart.setTotalPrice(totalPrice);
        cartMapper.insert(cart);
        //购物车信息写入后，调用orderInfoService.settle方法将购物车内商品清单信息写入
        orderInfoService.settle(cart.getCartUID());
        return "settle success";
    }

    //获取当前用户信息，默认2020
    @Override
    public long getOwnerId() {
        userUid = 2020;
        return userUid;
    }

    //获取购物车信息
    @Override
    public HashMap<Long, Goods> getCart() {
        myCart = (HashMap) session.getAttribute("myCart");
        if (myCart == null) {
            myCart = new HashMap<>();
            session.setAttribute("myCart", myCart);
        }
        //测试，即展示用，提交时可将print语句删除
        //注：在add,remove等方法中，因为调用此方法时是在操作数据之前，故print的myCart数据为修改前的
        System.out.println("session myCart size(before operator):" + myCart.size());
        System.out.println(JSONObject.toJSONString(myCart.entrySet().toArray()));
        return myCart;
    }
}
