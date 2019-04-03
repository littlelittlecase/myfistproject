package cn.xiaozhang.view;

import java.util.List;
import java.util.Scanner;

import cn.xiaozhang.controller.ZhangWuController;
import cn.xiaozhang.domain.Zhangwu;

/*
 * 视图层，用户看到和操作的界面
 * 数据传递个controller层实现
 * 成员为止，创建controller对象  
 * */

public class MainView {

	private ZhangWuController controller = new ZhangWuController();

	/*
	 * 实现界面效果 接受用户的输入 根据数据，调用不同的功能方法
	 */
	public void run() {
		// 创建scanner类对象，反复键盘输入
		Scanner sc = new Scanner(System.in);
		// 创建菜单
		while (true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			// 接受用户的选择
			int choose = sc.nextInt();
			// 对选择的菜单判断，调用不同的功能
			switch (choose) {
			// 添加账务功能
			case 1:
				addZhangwu();
				break;
			// 编辑账务
			case 2:
				editZhangwu();
				break;
			// 删除账务
			case 3:
				deleteZhangwu();
				break;
			// 查询账务
			case 4:
				selectZhangwu();
				break;
			// 退出系统
			case 5:
				System.out.println("再见");

				break;

			default:
				System.out.println("输入错误");

			}

		}

	}

	/*
	 * 定义方法，实现查询
	 */
	public void selectZhangwu() {
		System.out.println("1.查询所有   2.条件查询");
		Scanner sc = new Scanner(System.in);
		int selectchoose = sc.nextInt();
		switch (selectchoose) {
		case 1:
			// 查询所有方法
			selectall();
			break;
		case 2:
			// 条件查询
			select();
			break;

		}

	}

	/*
	 * 定义方法，实现条件查询账务数据 提供用户的输入日期，开始日期，结束日期 就2个日期，传递到controller层
	 * 调用controller的方法，传递两个日期的参数 获取到controller查询的结果集，打印出来
	 * 
	 */
	public void select() {
		// 调用控制层中的方法，查询符合条件的账务数据
		System.out.println("选择条件查询，输入日期格式：XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入开始日期");
		String startdate = sc.nextLine();
		System.out.println("请输入结束日期");
		String enddate = sc.nextLine();
		// 调用controller层的方法，传递日期，获取查询结果集
		List<Zhangwu> list = controller.select(startdate, enddate);
		if(list.size()!=0){
			printZhangwu(list);
			}else{
				System.out.println("没有查询到数据错误");
			}

	}

	public void selectall() {
		// 调用控制层中的查找所有的数据
		List<Zhangwu> list = controller.selectall();
		if(list.size()!=0){
		printZhangwu(list);
		}else{
			System.out.println("没有查询到数据错误");
		}

	}

	

	/*
	 * 定义方法，删除查询
	 */
	public void deleteZhangwu() {
		System.out.println("请输入要删除数据的日期：（格式为：XXXX-XX-XX）");
		//输入所要删除的数据的日期
		Scanner sc = new Scanner(System.in);
		String deletedate = sc.nextLine();
		// 调用控制层中的删除方法
		List<Zhangwu> list = controller.deleteZhangwu(deletedate);


	}

	/*
	 * 定义方法，编辑查询
	 */
	public void editZhangwu() {
		// 选择需要编辑的数据的id
		System.out.println("你选择的是编辑功能请，请输入一下内容");
		Scanner sc = new Scanner(System.in);
		System.out.println("你想编辑的数据id：");
		int wzid = sc.nextInt();
		System.out.println("请输入新的分类名称：");
		String flname = sc.next();
		System.out.println("请输入新账户：");
		String zhangHu = sc.next();
		
		System.out.println("请输入新金额：");
		double money = sc.nextDouble();
		System.out.println("请输入新时间：");
		String createtime = sc.next();
		System.out.println("请输入新说明：");
		String description = sc.next();
		//调用controller层的方法，传递参数
		Zhangwu zw = new Zhangwu(wzid, flname, money, zhangHu, createtime, description);
		controller.editZhangwu(zw);
		System.out.println("修改成功！！");
		
		

	}

	/*
	 * 定义方法，添加数据
	 */
	public void addZhangwu() {
		// 键盘输入,五项输入
		System.out.println("选择的添加账务功能，请输入一下内容");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入分类名称：");
		String flname = sc.next();
		System.out.println("请输入金额：");
		double money = sc.nextDouble();
		System.out.println("请输入账户：");
		String zhangHu = sc.next();
		System.out.println("请输入日期：（格式为：XXXX-XX-XX）");
		String createtime = sc.next();
		System.out.println("请输入描述：");
		String description = sc.next();
		//将接受到的数据，调用controller层的方法，传递参数
		//将用户输入的所有参数封装成Zhangwu对象
		Zhangwu zw = new Zhangwu(0, flname, money, zhangHu, createtime, description);
		controller.addZhangwu(zw);
		System.out.println("成功添加！！！！！");
		
		
		

	}
	
	//输出账务数据。接受list集合，便立即和，输出表格
	private void printZhangwu(List<Zhangwu> list) {
		// 输出表头
		System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t\t说明");
		// 遍历集合，结果输出控制台
		for (Zhangwu zhangwu : list) {
			System.out.println(zhangwu.getZwid() + "\t\t" + zhangwu.getFlname() + "\t\t" + zhangwu.getZhangHu() + "\t\t"
					+ zhangwu.getMoney() + "\t\t" + zhangwu.getCreatetime() + "\t\t" + zhangwu.getDescription());
		}
	}
	
	
}








