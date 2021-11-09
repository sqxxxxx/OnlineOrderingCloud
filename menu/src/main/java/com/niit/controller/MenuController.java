package com.niit.controller;

import com.niit.entity.Menu;
import com.niit.entity.Type;
import com.niit.dao.MenuMapper;
import com.niit.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@Transactional
public class MenuController {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    TypeMapper typeMapper;

    /*查询所有信息并且分页*/
    @GetMapping("/findAll/{index}/{limit}")
    public List< Menu > findAll(@PathVariable("index")Integer index, @PathVariable("limit")Integer limit){
        return menuMapper.findAll(index,limit);
    }
    /*M 查询所有信息数目*/
    @GetMapping("/count")
    public Integer count(){
        return menuMapper.count();
    }
    /*删除meno某个菜品*/
    @PutMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        menuMapper.deleteById(id);
    }
    /*查询单个产品*/
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id")long id){
        return menuMapper.findById(id);
    }
    /*查询所有菜品类型*/
    @GetMapping("/typeFindAll")
    public List<Type> TfindById(){
        return typeMapper.findAll();
    }

    /*修改菜品*/
    @PutMapping("/update/{id}")
    public void Mupdate(@PathVariable("id")long id,@RequestBody Menu menu){
        menuMapper.update(menu);
    }

    //添加菜品
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuMapper.save(menu);
    }
    //M 订单评价找到所有菜品
    @GetMapping("/findAllMenu")
    public List<Menu> findAllMenu(){
        return menuMapper.findAllMenu();
    }
}
