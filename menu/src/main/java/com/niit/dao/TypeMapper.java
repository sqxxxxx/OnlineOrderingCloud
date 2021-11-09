package com.niit.dao;

import com.niit.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {
    Type findById(Integer id);//通过id查询菜品类型
    List<Type> findAll();/*查询所有菜品类型*/
}
