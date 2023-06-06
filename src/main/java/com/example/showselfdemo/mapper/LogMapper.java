package com.example.showselfdemo.mapper;

import com.example.showselfdemo.dao.Log;

import java.util.List;

public interface LogMapper {
    Integer insertLog(Log log);
    List<Log> selectAllLog();
}
