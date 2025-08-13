package com.boot.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExampleMapper {
    public String getDate();

    @Select("select sysdate from dual")
    public String getTime();
}
