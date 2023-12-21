package com.mobin.carbon.service.impl;

import com.mobin.carbon.mapper.ItemUpholdMapper;
import com.mobin.carbon.pojo.ItemPphold;
import com.mobin.carbon.service.ItemUpholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemUpholdServiceImp implements ItemUpholdService {

    @Autowired
    private ItemUpholdMapper itemUpholdMapper;

    @Override
    public List<ItemPphold> findAll() {
        return itemUpholdMapper.findAll();
    }

    @Override
    public ItemPphold findById(int id) {
        return itemUpholdMapper.findById(id);
    }

    @Override
    public int delById(int id) {
        return itemUpholdMapper.delById(id);
    }

    @Override
    public int update(ItemPphold item) {
        return itemUpholdMapper.update(item);
    }

    @Override
    public int add(ItemPphold item) {
        return itemUpholdMapper.add(item);
    }
}
