package com.example.showselfdemo.controller;

import com.example.showselfdemo.dao.Log;
import com.example.showselfdemo.dao.R;
import com.example.showselfdemo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("log")
public class LogController {
    @Autowired
    LogService logService;
    @GetMapping("/getalllog")
    public R getAllLog(){
        List<Log> logs = logService.getallLog();
        if (!logs.isEmpty()&&logs!=null){
            return R.builder().code(HttpStatus.OK.value()).msg("请求成功").Data(logs).build();
        }
        else {
            return R.builder().code(HttpStatus.EXPECTATION_FAILED.value()).msg("没有日志").build();
        }
    }
}
