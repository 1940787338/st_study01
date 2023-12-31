package com.mobin.carbon.service;

import com.mobin.carbon.pojo.Nxyj;

import java.util.List;

public interface NxyjService {

    List<Nxyj> findAll();

    Nxyj findById(int id);

    int update(Nxyj nxyj);

    int add(Nxyj nxyj);

    int del(String id);
}
