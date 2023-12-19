package com.mobin.carbon.mapper;

import com.mobin.carbon.pojo.Nxyj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
}
