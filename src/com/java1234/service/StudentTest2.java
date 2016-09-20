package com.java1234.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java1234.mappers.StudentMapper;
import com.java1234.model.Student;
import com.java1234.util.SqlSessionFactoryUtil;

/** 
* @author  lqt: 
* @date 创建时间：2016年9月19日 下午9:58:47 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class StudentTest2 {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
	private StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);

	@Before
	public void setUp() throws Exception {
		sqlSession=SqlSessionFactoryUtil.openSession();
		studentMapper=sqlSession.getMapper(StudentMapper.class);

	}

	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	@Test
	public void testAdd() {
		logger.info("添加学生！");
		Student student=new Student("王5小",12);
		studentMapper.add(student);
		sqlSession.commit();
//		fail("Not yet implemented");

	}
	
	@Test
	public void teseUpdate() {
		logger.info("修改学生！");
		Student student=new Student(8,"马云",18);
		studentMapper.update(student);
		sqlSession.commit();
//		fail("Not yet implemented");

	}
	
	@Test
	public void testDelete(){
		logger.info("删除学生");
		studentMapper.delete(8);
		sqlSession.commit();
	}
	
	@Test
	public void testFindById(){
		logger.info("通过ID查找学生");
		Student student=studentMapper.findById(1);
		System.out.println(student);
	}
	
	@Test
	public void testFind(){
		logger.info("查找所有学生");
		List<Student> studentList=studentMapper.find();
		for(Student s:studentList){
			System.out.println(s);
		}
	}

}
