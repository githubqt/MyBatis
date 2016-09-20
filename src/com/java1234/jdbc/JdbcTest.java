package com.java1234.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 	TODO 
* @author  lqt: 
* @date 创建时间：2016年5月8日 上午8:43:47 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public class JdbcTest {
	private static JdbcTest JdbcTest;
	private Connection connection;
	private String driver = "com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost/mybatis?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false";
	private String userName = "root";
	private String pwd = "123456";


	private JdbcTest(){
	 try {
	 Class.forName(driver);		
	 } catch (ClassNotFoundException e) {
	 e.printStackTrace();
	 }catch(Exception e) {
	 e.printStackTrace();
	 }
			
	 }	
	
	public static JdbcTest getInstance(){
		if(JdbcTest==null){
			JdbcTest=new JdbcTest();
		}
		return JdbcTest;
	}

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, userName, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}
	public void free(ResultSet rs,PreparedStatement pstmt){
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
				rs = null;
			}
			
			if(pstmt!=null&&!pstmt.isClosed()){
				pstmt.close();
				pstmt=null;
			}
			
			if(connection!=null&&!connection.isClosed()){
				connection.close();
				connection=null;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcTest cn=new JdbcTest();
		if(cn.getConnection()!=null){
			System.out.println("数据库连接上了！");
		}else{
			System.out.println("数据库连接失败！");
		}
	}
}
