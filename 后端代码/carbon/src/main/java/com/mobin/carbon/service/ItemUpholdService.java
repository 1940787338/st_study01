package com.mobin.carbon.service;

import com.mobin.carbon.pojo.ItemPphold;

import java.util.List;

public interface ItemUpholdService {

    List<ItemPphold> findAll();

    ItemPphold findById(int id);

    int delById(int id);

    int update(ItemPphold item);

    int add(ItemPphold item);
}
