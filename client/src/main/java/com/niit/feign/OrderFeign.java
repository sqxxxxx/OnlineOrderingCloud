package com.niit.feign;


import com.niit.entity.Order;
import com.niit.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {
    /*M 保存订单*/
    @PostMapping("/order/save")
    void save(@RequestBody Order order);

    /* M 保存订单*/
    @PostMapping("/order/infosave")
    void orderSave(@RequestBody OrderInfo orderInfo);

    /* M 根据用户id查询订单*/
    @GetMapping("/order/findAllByUid/{uid}/{index}/{limit}")
    List <Order> findAllByUid(@PathVariable("uid") long uid, @PathVariable("index") int index, @PathVariable("limit") int limit);

    /*M 根据用户查询订单数量*/
    @GetMapping("/order/countByUid/{uid}")
    int countByUid(@PathVariable("uid") long uid);

    /*根据订单状态查询所有*/
//    @GetMapping("/order/findAllByState/{index}/{limit}")
//    List<Order> findAllByState(@PathVariable("index") int index, @PathVariable("limit") int limit);

    /*M 根据订单状态查询所有*/
    @GetMapping("/order/findAllByState/{index}/{limit}")
    List<Order> findAllByState(@RequestParam("date1")String date1,@RequestParam("date2")String date2,@RequestParam("state")int state,@PathVariable("index") int index, @PathVariable("limit") int limit);


    /*M 根据订单状态查询条数*/
    @GetMapping("/order/countByState")
    int countByState(@RequestParam("date1")String date1,@RequestParam("date2")String date2,@RequestParam("state")int state);

    /*M 查询所有订单条数*/
    @GetMapping("/order/countAllOrderInfo")
    int countAllOrderInfo();

    /*M 查询所有订单*/
    @GetMapping("/order/findAllOrder/{index}/{limit}")
    List<Order> findAllOrder(@PathVariable("index") int index, @PathVariable("limit") int limit);

    //订单评价
    @PutMapping("/order/evaluate")
    void evaluate(@RequestBody OrderInfo orderInfo);

    //用户退单
    @DeleteMapping("/order/deleteOrderInfo/{orderid}")
    int deleteOrderInfo(@RequestParam("userid")long userid,@PathVariable("orderid")long orderid);

    //用户退单
    @DeleteMapping("/order/deleteOrder/{orderid}")
    int deleteOrder(@RequestParam("userid")long userid,@PathVariable("orderid")long orderid);

//    修改订单状态
    @PutMapping("/order/updateState/{id}")
    int updateState(@PathVariable("id")long id);
}
