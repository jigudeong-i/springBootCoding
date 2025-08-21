package com.boot.example.mapper;

import com.boot.example.domain.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SubjectMapper {
    @Results(id="subjectResult", value={
            @Result(column = "no", property = "no"),
            @Result(column = "s_num", property = "subjectNumber"),
            @Result(column = "s_name", property = "subjectName"),
    })
    @Select("SELECT no, s_num, s_name FROM subject ORDER BY no")
    public List<Subject> subjectList();
}
