package cn.xiaozhang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.xiaozhang.domain.Zhangwu;
import cn.xiaozhang.tools.JDBCUtils;

public class ZhangWuDao {
	
	/*
	 * 实现对数据gjp_zhangwu数据增删改查操作
	 * dbutils工具类完成，类成员创建queryrunner对象，指定数据源
	 * */
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	public  List<Zhangwu> list = null;
	
	
	
	 public List<Zhangwu> select(String startdate,String enddate){
		 try {
		 //sql语句
		 String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
		 //定义对象数组，存储？占位符
		 Object[] params = {startdate,enddate};
		 //调用qr对象的方法，query查询数据表，获取结果集
		
			list = qr.query(sql, new BeanListHandler<>(Zhangwu.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return list;
		
		 
		
		 
	 }
	public List<Zhangwu> deleteZhangwu(String deletedate){
		try {
		//sql语句
		String sql = "DELETE FROM gjp_zhangwu WHERE createtime=?";
		//定义对象数组，存储？占位符
		Object[] params ={deletedate};
		//打印成功与否
			int row = qr.update(sql, params);
			if(row>0){
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		return list;
		
		
	}
	
	
	/*
	 * 定义方法，查询数据库，获取所有的账务数据
	 * 方法有业务层调用
	 * 结果集，将所有的账务数据，存储到bean对象中，存储到集合中
	 * */
	public List<Zhangwu> selectall(){
	
		
		try {
			//sql语句
			String sql = "SELECT * FROM gjp_zhangwu";
			//调用qr对象的方法，query方法，结果集beanlisthandler
			list = qr.query(sql, new BeanListHandler<>(Zhangwu.class));
			return list;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	/*
	 * 定义方法，实现添加账务功能
	 * 有业务调用，传递zhangwu对象
	 * 将Zhangwu对象中的数据，添加到数据表
	 * */
	
	public void addZhangwu(Zhangwu zw){
		try{
		//拼写sql语句
		String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?)";
		//创建对象数组，存储五个占位符的实际参数
		//实际参数来源是，传递过来的对象Zhangwu
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),
				             zw.getCreatetime(),zw.getDescription()};
		//调用qr对象中的方法update执行添加
		qr.update(sql, params);
		}catch(SQLException e){
			System.out.println(e);
			
		}
		
		
	}
	/*
	 * 编辑
	 * */
	public void editZhangwu(Zhangwu zw){
		try {
		//拼写sql语句
		String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhangHu=?,createtime=?,description=?  WHERE zwid=?";
		//创建对象参数，存储六个占位符的实际参数
		//实际参数的来源是传递过来的对象zhangwu
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		//调用qr的update执行修改编辑数据
			qr.update(sql, params);
		} catch (SQLException e) {
			
			System.out.println(e);
		}
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

}
