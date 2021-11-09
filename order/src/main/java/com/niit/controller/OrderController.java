package com.niit.controller;

import com.niit.entity.Order;
import com.niit.entity.OrderInfo;
import com.niit.dao.OrderInfoMapper;
import com.niit.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Transactional
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    //用户范围
    /*M 保存订单*/
    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderMapper.save(order);
    }

    //M 订单信息保存
    @PostMapping("/infosave")
    public void orderSave(@RequestBody OrderInfo orderInfo){
        orderInfoMapper.save(orderInfo);
    }


    /*M 根据用户id查询订单*/
    @GetMapping("/findAllByUid/{uid}/{index}/{limit}")
    public List<Order> findAllByUid(@PathVariable("uid")long uid, @PathVariable("index")int index, @PathVariable("limit")int limit){
        return orderMapper.findAllByUid(uid, index, limit);
    }

    /*M  根据用户查询订单数量*/
    @GetMapping("/countByUid/{uid}")
    public int countByUid(@PathVariable("uid") long uid){
//        return orderMapper.countByUid(uid);
        return orderInfoMapper.countByUid(uid);
    }

    //管理员范围
    /*根据订单状态查询所有*/
//    @GetMapping("/findAllByState/{index}/{limit}")
//    public List<Order> findAllByState(@PathVariable("index")int index,@PathVariable("limit")int limit){
//        return orderMapper.findAllByState(index, limit);
//    }
    /*根据订单状态查询所有*/
    @GetMapping("/findAllByState/{index}/{limit}")
    public List<Order> findAllByState(@RequestParam("date1")String date1,@RequestParam("date2")String date2,@RequestParam("state")int state,@PathVariable("index")int index,@PathVariable("limit")int limit){
        return orderMapper.findAllByState(date1,date2,state,index, limit);
    }
    /* 根据订单状态查询条数*/
    @GetMapping("/countByState")
    public int countByState(@RequestParam("date1")String date1,@RequestParam("date2")String date2,@RequestParam("state")int state){
        return orderInfoMapper.countByState(date1,date2,state);
    }

    /*M 查询所有订单条数*/
    @GetMapping("/countAllOrderInfo")
    public int countAllOrderInfo(){
        return orderInfoMapper.countAllOrderInfo();
    }

    /*M 查询所有订单*/
    @GetMapping("/findAllOrder/{index}/{limit}")
    public List<Order> findAllOrderInfo(@PathVariable("index")int index,@PathVariable("limit")int limit){
        return orderMapper.findAllOrder(index, limit);
    }

    /*修改订单状态*/
    @PutMapping("/updateState/{id}/{aid}")
    public void updateState(@PathVariable("id")long id,@PathVariable("aid")long aid){
        orderMapper.updateState(id,aid);
    }

    //订单评价
    @PutMapping("/evaluate")
    public void evaluate(@RequestBody OrderInfo orderInfo){
         orderInfoMapper.evaluate(orderInfo);
    }

    //用户退单
    @DeleteMapping("/deleteOrderInfo/{orderid}")
    public int deleteOrderInfo(@RequestParam("userid")long userid,@PathVariable("orderid")long orderid){
        return orderInfoMapper.delete(userid,orderid);
    }

    //用户退单
    @DeleteMapping("/deleteOrder/{orderid}")
    public int deleteOrder(@RequestParam("userid")long userid,@PathVariable("orderid")long orderid){
        return orderMapper.delete(userid, orderid);
    }

    //修改订单状态
    @PutMapping("/updateState/{id}")
    public int updateState(@PathVariable("id")long id){
        return orderInfoMapper.updateState(id);
    }
}
