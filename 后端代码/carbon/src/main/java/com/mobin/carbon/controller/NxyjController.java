package com.mobin.carbon.controller;

import com.mobin.carbon.pojo.Nxyj;
import com.mobin.carbon.pojo.Result;
import com.mobin.carbon.service.NxyjService;
import com.mobin.carbon.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/nxyj")
public class NxyjController {

    @Autowired
    private NxyjService nxyjService;

    // 查询所有
    @RequestMapping("/findall")
    public Result findAll(HttpServletRequest request) {
        Logger.writeLog(request, "查询所有能效预警");
        List<Nxyj> all = nxyjService.findAll();
        log.info("查询所有能效预警: {}", all);
        return Result.success(all);
    }

    //根据id 查询
    @RequestMapping("/{id}")
    public Result findById(@PathVariable Integer id, HttpServletRequest request) {
        Logger.writeLog(request, "查询预警");
        Nxyj nxyj = nxyjService.findById(id);
        log.info("修改效预警: {}", id);
        return Result.success(nxyj);
    }

    //修改接口
    @RequestMapping("/update")
    public Result update(@RequestBody Nxyj nxyj, HttpServletRequest request) {
        //因为前端传过来的是数字类型，加上实时功率的W 和 实时电压的V
        nxyj.setPower(nxyj.getPower() + "W");
        nxyj.setVoltage(nxyj.getVoltage() + "V");

        Logger.writeLog(request, "修改能效预警");
        log.info("修改能效预警: {}", nxyj);
        nxyjService.update(nxyj);
        return Result.success();
    }


    @RequestMapping("/add")
    public Result add(@RequestBody Nxyj nxyj, HttpServletRequest request) {
        //因为前端传过来的是数字类型，加上实时功率的W 和 实时电压的V
        nxyj.setPower(nxyj.getPower() + "W");
        nxyj.setVoltage(nxyj.getVoltage() + "V");

        Logger.writeLog(request, "添加能效预警");
        log.info("添加能效预警: {}", nxyj);
        int add = nxyjService.add(nxyj);
        if (add > 0) {
            return Result.success();
        }

        return Result.error("添加失败");

    }

    @RequestMapping("/del")
    public Result del(String id, HttpServletRequest request) {
        Logger.writeLog(request, "删除能效预警");
        log.info("删除能效预警: {}", id);
        int del = nxyjService.del(id);
        if (del > 1) {
            return Result.success();
        }

        return Result.error("删除失败");
    }
}
