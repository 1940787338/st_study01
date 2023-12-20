package com.mobin.carbon.filter;

import com.mobin.carbon.pojo.ItemPphold;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemUpholdMapper {

    @Select("select * from item_pphold")
    List<ItemPphold> findAll();
}
