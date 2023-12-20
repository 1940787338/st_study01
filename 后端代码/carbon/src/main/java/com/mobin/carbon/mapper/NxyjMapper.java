package com.mobin.carbon.mapper;

import com.mobin.carbon.pojo.Nxyj;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NxyjMapper {

    //查询所有
    @Select("select * from nxyj")
    List<Nxyj> findAll();

    @Select("select *from nxyj where id = #{id}")
    Nxyj findById(int id);

    @Update("update nxyj set name = #{name}, address = #{address}, power = #{power}, voltage = #{voltage}, status = #{status}, notes = #{notes}, update_time = now() where id = #{id}")
    int update(Nxyj nxyj);

    @Insert("insert into nxyj values(null, #{name}, #{address}, #{power}, #{voltage}, #{status}, now(), #{notes}, now(), now())")
    int add(Nxyj nxyj);

    @Delete("delete from nxyj where id = #{id}")
    int del(String id);
}
