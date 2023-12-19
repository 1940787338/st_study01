package com.mobin.carbon.mapper;

import com.mobin.carbon.pojo.Nxyj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NxyjMapper {

    //查询所有
    @Select("select * from nxyj")
    List<Nxyj> findAll();
}
