package com.mobin.carbon.controller;

import com.mobin.carbon.pojo.ItemPphold;
import com.mobin.carbon.pojo.Result;
import com.mobin.carbon.service.ItemUpholdService;
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
@RequestMapping("/xmwh")
public class ItemUpholdController {
    @Autowired
    private ItemUpholdService itemUpholdService;


    @RequestMapping("/all")
    public Result findAll(HttpServletRequest request) {
        Logger.writeLog(request, "查询所有项目维护");
        log.info("查询所有项目维护");
        List<ItemPphold> all = itemUpholdService.findAll();
        return Result.success(all);
    }

    @RequestMapping("/{id}")
    public Result findById(@PathVariable Integer id, HttpServletRequest request) {
        Logger.writeLog(request, "通过id 查询项目维护");
        log.info("通过id 查询项目维护: {}", id);
        ItemPphold byId = itemUpholdService.findById(id);
        return Result.success(byId);
    }

    @RequestMapping("/del/{id}")
    public Result delById(@PathVariable Integer id, HttpServletRequest request) {
        Logger.writeLog(request, "通过id 删除项目维护");
        log.info("通过id 删除项目维护: {}", id);
        int i = itemUpholdService.delById(id);
        if (i > 0) {
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ItemPphold itemPphold, HttpServletRequest request) {
        Logger.writeLog(request, "修改项目维护");
        log.info("修改项目维护: {}", itemPphold);
        int update = itemUpholdService.update(itemPphold);
        if (update > 0) {
            return Result.success();
        }
        return Result.error("修改失败");
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ItemPphold itemPphold, HttpServletRequest request) {
        Logger.writeLog(request, "添加项目维护");
        log.info("添加项目维护: {}", itemPphold);
        int add = itemUpholdService.add(itemPphold);
        if (add > 0) {
            return Result.success();
        }
        return Result.error("添加失败");
    }
}
