package com.niit.controller;



import com.niit.config.BaseOnSnowflake;
import com.niit.entity.*;
import com.niit.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auther snowy
 * @date 2020/2/8 - 14:09
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    OrderFeign orderFeign;

    /*M  保存订单*/
    @PostMapping("/infosave")
    @ResponseBody
    public Msg orderSave(HttpSession session, @RequestBody List<OrderUtil>list){
        //@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)，所以只能发送POST请求。一个请求，只有一个RequestBody；一个请求，可以有多个RequestParam。

        //首先填写orderinfo表
        OrderInfo orderInfo=new OrderInfo();
        User user = (User) session.getAttribute("user");
        orderInfo.setUser(user);
        BaseOnSnowflake baseOnSnowflake=new BaseOnSnowflake(1,1,1);
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//        df.setTimeZone(TimeZone.getTimeZone("ETC/GMT-8"));
//        long orderId=Long.parseLong(df.format(new Date())+(int)((Math.random()*9+1)*10000));// 前者new Date()为获取当前系统时间，后者为生成5位随机数字
        long orderId=baseOnSnowflake.nextId();
        orderInfo.setOrderid(orderId);
        orderInfo.setTotal(list.get(list.size()-1).getTotal());
        orderInfo.setMoney(list.get(list.size()-1).getMoney());
        orderInfo.setDate(new Date());
        orderFeign.orderSave(orderInfo);

        //再填写order表
        Order order=new Order();
        order.setOrderinfo(orderInfo);
        order.setUser(user);
        Menu menu=new Menu();
        for(int i=0;i<list.size()-1;i++){
            menu.setId(list.get(i).getId());
            order.setMenu(menu);
            order.setCount(list.get(i).getTotal());
            order.setSubtotal(list.get(i).getMoney());
            orderFeign.save(order);
        }
//        for(OrderUtil orderUtil :list){
//            System.out.println(orderUtil.toString());
//        }
        return Msg.success();
    }


    /*M 根据用户id查询订单*/
    @GetMapping("/findAllByUid")
    @ResponseBody
    public AllVO findAllByUid(@RequestParam("page")int page, @RequestParam("limit")int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        return new AllVO(0,"",orderFeign.countByUid(user.getId()),orderFeign.findAllByUid(user.getId(),(page-1)*limit,limit));
    }

    /*M 查询所有订单*/
    @GetMapping("/findAllOrder")
    @ResponseBody
    public AllVO findAllOrder(@RequestParam("page")int page, @RequestParam("limit")int limit){
        return new AllVO(0,"",orderFeign.countAllOrderInfo(),orderFeign.findAllOrder((page-1)*limit,limit));
    }

    /*M 修改订单状态*/
    @PutMapping("/updateState/{id}")
    @ResponseBody
    public Msg updateState(@PathVariable("id")long id){
        return orderFeign.updateState(id)>0?Msg.success():Msg.fail();
    }


    /*根据订单状态查询所有*/
//    @GetMapping("/findOrderByState")
//    @ResponseBody
//    public AllVO findOrderByState(@RequestParam("times")String date,@RequestParam("state")int state,@RequestParam("page")int page, @RequestParam("limit")int limit){
//        String []datestring=date.split("~");
//        String date1=datestring[0];
//        String date2=datestring[1];
//        System.out.println(date1+"  "+date2);
//        return new AllVO(0,"",orderFeign.countByState(date1,date2,state),orderFeign.findAllByState(date1,date2,state,page-1,limit));
//    }
    /*根据订单状态查询所有*/
    @GetMapping("/findOrderByState")
    @ResponseBody
    public AllVO findOrderByState(@RequestParam(value="times",required = false)String date, @RequestParam(value = "state",required = false)Integer state, @RequestParam("page")int page, @RequestParam("limit")int limit){

        if(date!="" &&state!=null){
            String []datestring=date.split("~");
            String date1=datestring[0];
            String date2=datestring[1];
            System.out.println(date+" "+state);
            return new AllVO(0,"",orderFeign.countByState(date1,date2,state),orderFeign.findAllByState(date1,date2,state,(page-1)*limit,limit));
        }
        else if(state!=null  && date==""){
            return new AllVO(0,"",orderFeign.countByState("","",state),orderFeign.findAllByState("","",state,(page-1)*limit,limit));
        }
        return new AllVO(0,"",orderFeign.countByState("","",-1),orderFeign.findAllByState("","",-1,(page-1)*limit,limit));

    }

//    String []arr=menuname.split("[\\* | = |,]");//*需要转义，符号间用|分割


    //订单id，订单评价
    @PutMapping("/evaluate")
    @ResponseBody
    public Msg orderEvaluate(HttpSession session,OrderInfo orderinfo){
        User user=(User)session.getAttribute("user");
        orderinfo.setUser(user);
        System.out.println(orderinfo.toString());
        orderFeign.evaluate(orderinfo);
        return Msg.success();
    }

    //订单删除,待测试
    @DeleteMapping("/delete/{orderid}")
    public Msg deleteOrder(HttpSession session,@PathVariable("orderid")long orderid){
        User user=(User)session.getAttribute("user");
        return orderFeign.deleteOrder(user.getId(),orderid)>0&&orderFeign.deleteOrderInfo(user.getId(),orderid)>0?Msg.success():Msg.fail();
    }


}
