package com.niit.feign;

import com.niit.entity.Menu;
import com.niit.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@FeignClient(value = "menu")
public interface MenuFeign {

    /*查询所有信息并且分页*/
    @GetMapping("/menu/findAll/{index}/{limit}")
    List<Menu> findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit);

    /*M 查询所有信息数目*/
    @GetMapping("/menu/count")
    Integer count();

    /*删除meno某个菜品*/
    @PutMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);//Integer id

    /*查询单个产品*/
    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);//Integer id

    /*查询所有菜品类型*/
    @GetMapping("/menu/typeFindAll")
    List<Type> TfindById();

    /*修改菜品*/
    @PutMapping("/menu/update/{id}")
    void Mupdate(@PathVariable("id") long id, @RequestBody Menu menu);

    //添加菜品
    @PostMapping("/menu/save")
    void save(@RequestBody Menu menu);

    //M 订单评价找到所有菜品
    @GetMapping("/menu/findAllMenu")
    List<Menu> findAllMenu();

}
