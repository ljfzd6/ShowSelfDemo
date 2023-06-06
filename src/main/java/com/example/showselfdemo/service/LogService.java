package com.example.showselfdemo.service;

import com.example.showselfdemo.dao.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogService {
     Integer addLog(Log log);
     List<Log> getallLog();
}
