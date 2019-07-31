package com.exit.manytoone.controller;

import com.exit.manytoone.entity.Clazz;
import com.exit.manytoone.entity.Student;
import com.exit.manytoone.service.StudentService;
import com.exit.manytoone.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudentList.do")
    public String getStudentList(Model model, @RequestParam(name = "cpage",defaultValue = "1")int cpage,
                                 @RequestParam(name = "mohu",defaultValue = "")String mohu){

        int pageSize = 3;
        int index = (cpage-1)*pageSize;//每页总条数

        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("pageSize",pageSize);
        paramMap.put("index",index);
        paramMap.put("mohu",mohu);

        List<Map<String,Object>> mapStudentList = studentService.getMapStudentList(paramMap);
        int count = studentService.getCount(paramMap);

        Map<String, Object> page = PageUtil.page("getStudentList.do", cpage, pageSize, count, mohu);

        model.addAttribute("mapStudentList",mapStudentList);
        model.addAttribute("page",page);
        model.addAttribute("mohu",mohu);
        return "list";
    }

    @RequestMapping("toAdd.do")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("getClazzList.do")
    @ResponseBody
    public Object getClazzList(){
        List<Map<String,Object>> mapClazzList = studentService.getClazzList();
        return mapClazzList;
    }

    @RequestMapping("addStudentList.do")
    public String addStudentList(Student student){
        studentService.addStudentList(student);
        return "redirect:getStudentList.do";
    }

    @RequestMapping("deleteplsc.do")
    public String deleteplsc(String id){
        studentService.deleteplsc(id);
        return "redirect:getStudentList.do";
    }

    @RequestMapping("deleteStudent.do")
    public String deleteStudent(String id){
        studentService.deleteplsc(id);
        return "redirect:getStudentList.do";
    }

    @RequestMapping("toUpdate.do")
    public String toUpdate(Model model,String id){
        model.addAttribute("id",id);
        return "update";
    }

    @RequestMapping("chakan.do")
    public String chakan(Model model,String id){
        model.addAttribute("id",id);
        return "chakan";
    }


    @RequestMapping("getStudentById.do")
    @ResponseBody
    public Object getStudentById(Student student){
    student = studentService.getStudentById(student);
        return student;
    }


    @RequestMapping("updateStudentList.do")
    public String updateStudentList(Student student){
        System.out.println(student+"-------");
        studentService.updateStudentList(student);
        return "redirect:getStudentList.do";
    }





}
