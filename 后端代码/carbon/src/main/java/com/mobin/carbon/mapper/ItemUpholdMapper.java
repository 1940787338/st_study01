package com.mobin.carbon.mapper;

import com.mobin.carbon.pojo.ItemPphold;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ItemUpholdMapper {

    @Select("select * from item_pphold")
    List<ItemPphold> findAll();


    @Select("select * from item_pphold where id = #{id}")
    ItemPphold findById(int id);

    @Delete("delete from item_pphold where id = #{id}")
    int delById(int id);

    @Update("update item_pphold set item_name = #{itemName}, head_person = #{headPerson}, start_date = #{startDate}, end_date = #{endDate}, status = #{status}, introduction = #{introduction}, update_time = now() where id = #{id}")
    int update(ItemPphold itemPphold);

    //加入
    @Insert("insert into item_pphold values (null, #{itemName}, #{headPerson}, #{startDate}, #{endDate}, #{status}, #{introduction}, now(), now())")
    int add(ItemPphold itemPphold);
}
