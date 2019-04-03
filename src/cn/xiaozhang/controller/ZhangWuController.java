package cn.xiaozhang.controller;

import java.util.List;

import cn.xiaozhang.domain.Zhangwu;
import cn.xiaozhang.service.ZhangWuService;

/*
 * 控制器层 
 * 接受视图层的数据，数据传递给service层
 * 成员位置，创建service对象
 * 
 * */

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	
 	/*
 	 * 
 	 * 定义方法，实现条件查询账务
 	 * 方法由视图层调用，传递两个日期的字符串
 	 * 调用service层的方法，传递两个日期字符串，获取结果集
 	 * 结果集返回给视图层
 	 * */
	
	public List<Zhangwu> select(String startdate,String enddate){
		return service.select(startdate, enddate);
		
	}

	/*
	 * 控制类定义方法，实现查询所有的账务数据
	 * 方法由视图层调用，方法调用service层
	 * 
	 * */
	public List<Zhangwu> selectall(){
		return service.selectall();
	}
	
	/*定义删除方法，实现删除特点的数据
	 * 方法由视图层调用，方法调用service层
	 * */
	
	public List<Zhangwu> deleteZhangwu(String deletedate){
		return service.deleteZhangwu(deletedate);
		
	}
	
	/*
	 * 定义添加方法，实现添加数据的功能
	 * 方法由视图层调用，传递参数，（传递过来的参数不能是五个数据，传递的是一个zhangwu类型的对象）方法调用service层
	 *方法调用service层的方法，传递zhangwu对象，获取添加后的结果集，（添加成功的行数，int） 
	 * */
	public void addZhangwu(Zhangwu zw){
		service.addZhangwu(zw);

	}
	
	public void editZhangwu(Zhangwu zw){
		
		service.editZhangwu(zw);
	}
	
	
	
	
	
	
	
	
	
	
	

}
