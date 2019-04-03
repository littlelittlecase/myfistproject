package cn.xiaozhang.service;

import java.util.List;

import cn.xiaozhang.dao.ZhangWuDao;
import cn.xiaozhang.domain.Zhangwu;

/*
 * 业务层类
 * 接受上一层，控制层contraller的数据
 * 经过计算，传递给dao层，操作数据库
 * 调用dao层中的类，类成员位置，创建dao类的对象
 * 
 * */

public class ZhangWuService {

	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * 定义方法，实现查询的所有账务数据
	 * 此方法，由控制层调用，去调用dao层的方法
	 * 返回存储zhangwu对象的list集合
	 * */
	public List<Zhangwu> selectall(){
		return dao.selectall();
		
	}
	
	
	/*
	 * 定义方法，实现查询的符合条件的账务数据
	 * 此条件，被控制层调用，传递两个日期字符串，
	 * 去调用dao层的方法，传递两个日期的字符串
	 * 返回存储zhangwu对象的list集合
	 * */
	public List<Zhangwu> select(String startdate,String enddate){
		return dao.select(startdate, enddate);
		
	}
	
	/*删除*/
	public List<Zhangwu> deleteZhangwu(String deletedate){
		return dao.deleteZhangwu(deletedate);
		
		
	}
	
	/*
	 * 定义方法，实现添加账务
	 * 是被控制层调用，调用的是dao层，传递的都是zhangwu对象
	 * */
	public void addZhangwu(Zhangwu zw){
		dao.addZhangwu(zw);
		
		
	}
	
	
	/*编辑
	 * 被控制层调用，调用dao层的方法
	 * */
	public void editZhangwu(Zhangwu zw){
		
		dao.editZhangwu(zw);
	}
	
	
	
	
	
	
}
