package com.sxteng.hutool.service;

import com.sxteng.hutool.vo.StudentVO;

public class StudentService {

    public void getStudent(){
        StudentVO studentVO = new StudentVO();
        System.out.println(studentVO instanceof  StudentVO);
        studentVO.setAddress("22222");

    }
}

