package com.example.showselfdemo.service.impl;

import com.example.showselfdemo.dao.Log;
import com.example.showselfdemo.mapper.LogMapper;
import com.example.showselfdemo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public Integer addLog(Log log) {
        return logMapper.insertLog(log);
    }

    @Override
    public List<Log> getallLog() {
        return logMapper.selectAllLog();
    }
}
