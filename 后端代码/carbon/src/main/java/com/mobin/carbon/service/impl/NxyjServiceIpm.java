package com.mobin.carbon.service.impl;

import com.mobin.carbon.mapper.NxyjMapper;
import com.mobin.carbon.pojo.Nxyj;
import com.mobin.carbon.service.NxyjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NxyjServiceIpm implements NxyjService {

    @Autowired
    private NxyjMapper nxyjMapper;

    @Override
    public List<Nxyj> findAll() {
        return nxyjMapper.findAll();
    }

    @Override
    public Nxyj findById(int id) {
        return nxyjMapper.findById(id);
    }

    @Override
    public int update(Nxyj nxyj) {
        return nxyjMapper.update(nxyj);
    }

    @Override
    public int add(Nxyj nxyj) {
        return nxyjMapper.add(nxyj);
    }

    @Override
    public int del(String id) {
        return nxyjMapper.del(id);
    }
}
