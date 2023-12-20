package com.mobin.carbon.controller;

import com.mobin.carbon.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UploadController {

    @RequestMapping("/upload")
    public Result test(){
        return Result.success();
    }

}
