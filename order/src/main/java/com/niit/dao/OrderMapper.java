package com.niit.dao;

import com.niit.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper {

    //M 保存订单
    void save(Order order);

    // M 根据用户id查询订单
    List<Order> findAllByUid(long uid, int index, int limit);

    //M  根据用户查询订单数量
    int countByUid(long uid);


    void deleteByMid(long mid);//管理员删除订单
    void deleteByUid(long uid);//用户删除订单


//    List<Order> findAllByState(int index,int limit);

    //根据订单状态查询所有
    List<Order> findAllByState(@Param("date1") String date1,@Param("date2") String date2,@Param("state") int state,@Param("index") int index,@Param("limit") int limit);

    //M 根据订单状态查询条数
    int countByState();

    //M 查询所有订单
    List<Order> findAllOrder(int index,int limit);

    void updateState(long id,long aid);//修改订单状态

    int delete(long userid,long orderid);
}
