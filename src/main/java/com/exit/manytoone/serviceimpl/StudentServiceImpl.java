package com.exit.manytoone.serviceimpl;

import com.exit.manytoone.entity.Student;
import com.exit.manytoone.mapper.StudentMapper;
import com.exit.manytoone.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public List<Map<String, Object>> getMapStudentList(Map<String, Object> paramMap) {
        return studentMapper.getMapStudentList(paramMap);
    }

    @Override
    public int getCount(Map<String, Object> paramMap) {
        return studentMapper.getCount(paramMap);
    }

    @Override
    public List<Map<String, Object>> getClazzList() {
        return studentMapper.getClazzList();
    }

    @Override
    public void addStudentList(Student student) {
        studentMapper.addStudentList(student);
    }

    @Override
    public void deleteplsc(String id) {
        studentMapper.deleteplsc(id);
    }

    @Override
    public Student getStudentById(Student student) {
        return studentMapper.getStudentById(student);
    }

    @Override
    public void updateStudentList(Student student) {
        System.out.println(student);
        studentMapper.updateStudentList(student);
    }
}
