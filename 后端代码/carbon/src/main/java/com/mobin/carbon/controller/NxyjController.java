package com.mobin.carbon.controller;

import com.mobin.carbon.pojo.Nxyj;
import com.mobin.carbon.pojo.Result;
import com.mobin.carbon.service.NxyjService;
import com.mobin.carbon.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController("/nxyj")
public class NxyjController {

    @Autowired
    private NxyjService nxyjService;

    @RequestMapping("/findall")
    public Result findAll(HttpServletRequest request) {
        log.info("查询所有能效预警");
        Logger.writeLog(request, "查询所有能效预警");
        List<Nxyj> all = nxyjService.findAll();
        return Result.success(all);
    }
}
