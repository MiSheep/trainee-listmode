package com.bosssoft.hr.train.utils;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class test {
//    @Autowired
//    private OrderInfoMapper orderInfoMapper;
//    @Test
//    public void testDataSource() throws SQLException{
//        System.out.println("成功！");
//        System.out.println(dataSource.getConnection());
//    }
//    @Test
//    public void testInsert(){
//        OrderInfo order = new OrderInfo();
//        order.setOrderList("xxxx");
//        order.setUserUID((long) 444);
//        orderInfoMapper.insert(order);
//        System.out.println(order.getOrderUID());
//    }
//    @Test
//    public void testUpdate(){
//        OrderInfo orderInfo = new OrderInfo();
//        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("orderUID","1");
//
//        orderInfo.setUserUID((long) 10);
//        //emplopyeeDao.updateById(employee);//根据id进行更新，没有传值的属性就不会更新
//        orderInfoMapper.update(orderInfo,queryWrapper);
//        int i = orderInfoMapper.selectCount(queryWrapper);
//        System.out.println("aaa:"+i);
//        //orderInfoMapper.updateAllColumnById(orderInfo);//根据id进行更新，没传值的属性就更新为null（在3版本弃用）
//    }
//    @Test
//    public void testSelect(){
//        OrderInfo orderInfo = new OrderInfo();
//        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
//        List<Long> list = new ArrayList<>();
//        list.add((long) 1);
//        list.add((long) 2);
////        OrderInfo orderInfo = new OrderInfo();
////        orderInfo.setOrderUID((long) 1);
////        orderInfo.setOrderList("xxx");
////若是数据库中符合传入的条件的记录有多条，那就不能用这个方法，会报错
//        List<OrderInfo> list1 = orderInfoMapper.selectBatchIds(list);
//        list1.forEach(item->{
//            System.out.println(item.getUserUID());
//        });
//        List<OrderInfo> list2 = orderInfoMapper.selectList(queryWrapper);
//        System.out.println(list2.size());
//    }
}
