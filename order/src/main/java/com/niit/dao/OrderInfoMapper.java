package com.niit.dao;

import com.niit.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 君已陌路
 * @date 2021/10/4 0:05
 */
@Repository
public interface OrderInfoMapper {
        //保存订单信息
        void save(OrderInfo orderInfo);
        //查询某用户订单数量
        int countByUid(long uid);
        //查询所有订单条数
        int countAllOrderInfo();

        //根据状态查询订单
        int countByState(@Param("date1") String date1, @Param("date2")String date2, @Param("state")int state);
        //订单评价
        void evaluate(OrderInfo orderInfo);

        int delete(long userid,long orderid);

        int updateState(long id);

}
