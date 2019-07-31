package com.exit.manytoone.mapper;

import com.exit.manytoone.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Map<String, Object>> getMapStudentList(Map<String, Object> paramMap);

    int getCount(Map<String, Object> paramMap);

    List<Map<String, Object>> getClazzList();

    void addStudentList(Student student);

    void deleteplsc(String id);

    Student getStudentById(Student student);

    void updateStudentList(Student student);
}
