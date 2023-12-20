package com.mobin.carbon.controller;

import com.mobin.carbon.pojo.ItemPphold;
import com.mobin.carbon.pojo.Result;
import com.mobin.carbon.service.ItemUpholdService;
import com.mobin.carbon.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
}
