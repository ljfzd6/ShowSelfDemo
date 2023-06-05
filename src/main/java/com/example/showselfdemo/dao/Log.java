package com.example.showselfdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {
    Integer id;
    Date logtime;
    String logcontext,loguser;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logtime=" + logtime +
                ", logcontext='" + logcontext + '\'' +
                ", loguser='" + loguser + '\'' +
                '}';
    }
}
