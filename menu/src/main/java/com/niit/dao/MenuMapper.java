package com.niit.dao;

import com.niit.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper {
    List<Menu> findAll(Integer index, Integer limit);/*查询所有信息并且分页*/
    Integer count();/*查询所有信息数目*/
    Menu findById(long id);/*查询单个产品*/
    void save(Menu menu);//添加菜品
    void update(Menu menu);/*修改菜品*/
    void deleteById(long id);/*删除menu某个菜品*/
    //M 订单评价找到所有菜品
    List<Menu> findAllMenu();
}
