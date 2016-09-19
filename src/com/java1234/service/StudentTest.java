package com.java1234.service;

import org.apache.ibatis.session.SqlSession;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

public class StudentTest {

	public static void main(String[] args) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
		Student student=new Student("王4小",12);
		int result=studentMapper.add(student);
		sqlSession.commit();
		if(result>0){
			System.out.println("添加成功！");
		}
	}
}
