package cn.xiaozhang.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 获取数据库链接的工具类
 * 实现链接池，dbcp连接池
 * */
public class JDBCUtils {

	//创建basicdatasource对象       建立池链接的属性配置对象
	private static BasicDataSource datasource = new BasicDataSource();//javax.sql的基本实现。通过javabean属性配置的数据源
      
	//静态代码块，实现必要的参数设置
	static{
		datasource.setUsername("root");
		datasource.setPassword("123");
		datasource.setUrl("jdbc:mysql://localhost:3306/mydb3");
		datasource.setMaxActive(10);
		datasource.setMaxIdle(5);
		datasource.setInitialSize(10);

	}
	public static DataSource getDataSource(){
		return datasource;//返回实现类对象
		
		
	}
	
	
}
