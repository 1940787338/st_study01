package com.mobin.carbon.service.impl;

import com.mobin.carbon.filter.ItemUpholdMapper;
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
}
