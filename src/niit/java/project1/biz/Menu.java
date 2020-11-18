package niit.java.project1.biz;

import java.util.Scanner;

/**
 * 菜单类，用于显示所有级菜单供用户选择
 * 
 * @author
 * 
 */
public class Menu {
//属性
	private String 	goodsName [];	// 商品的名称
	private double 	goodsPrice[];	// 商品的价格
	private int 	custNo	  [];	// 顾客的会员号
	private String 	custBirth [];	// 顾客的生日
	private int 	custScore [];	// 顾客的积分
 
	//get set 方法
	public String[] getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String[] goodsName) {
		this.goodsName = goodsName;
	}

	public double[] getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double[] goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int[] getCustNo() {
		return custNo;
	}

	public void setCustNo(int[] custNo) {
		this.custNo = custNo;
	}

	public String[] getCustBirth() {
		return custBirth;
	}

	public void setCustBirth(String[] custBirth) {
		this.custBirth = custBirth;
	}

	public int[] getCustScore() {
		return custScore;
	}

	public void setCustScore(int[] custScore) {
		this.custScore = custScore;
	}

	
	
//无参构造方法
	public Menu() {
	}
 

	
	/**
	 * 显示一级菜单，即登录界面
	 * 
	 */
	public void showLoginMenu() {
		System.out.println("\n\n\t\t\t    欢迎使用我行我素购物管理系统\n\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 登 录 系 统\n\n");
		System.out.println("\t\t\t\t 2. 更 改 管 理 员 信 息\n\n");
		System.out.println("\t\t\t\t 3. 退 出\n\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字:");
	}
 
	/**
	 * 显示二级菜单，即系统的主菜单，这个方法里面包含了对这个菜单处理的所有流程
	 * 
	 */
	public void showMainMenu() {
		
		// 显示二级菜单，即系统的主菜单
		System.out.println("\n\n\t\t\t\t欢迎使用购物管理系统\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 客 户 信 息 管 理\n");
		System.out.println("\t\t\t\t 2. 购 物 结 算\n");
		System.out.println("\t\t\t\t 3. 真 情 回 馈\n");
		System.out.println("\t\t\t\t 4. 注 销\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		
		// 用户选择服务项目
		System.out.print("请选择,输入数字:");
		Scanner scanner = new Scanner(System.in);
		
		// 设置标志用于控制循环
		boolean flag = false;
		do {
			String s = scanner.next();
			
			// 用户选择"客户信息管理"
			if (s.equals("1")) {
				// 显示客户信息管理菜单并处理这个菜单的整个流程，当这个流程处理完
				showCustMMenu();
				break;
			}
			
			// 用户选择"购物结算"
			if (s.equals("2")) {
				// 定义购物结算类的对象，并处理整个购物结算的流程
				Pay pay = new Pay();
				pay.setGoodsName(this.getGoodsName());
				pay.setGoodsPrice(this.getGoodsPrice());
				pay.setCustNo(this.getCustNo());
				pay.setCustBirth(this.getCustBirth());
				pay.setCustScore(this.getCustScore());
				
				pay.calcPrice();
				break;
			}
			
			// 用户选择"真情回馈"
			if (s.equals("3")) {
				// 处理真情回馈的整个处理流程
				showSendMenu();
				break;
			}
			
			// 用户选择"注销"
			if (s.equals("4")) {
				// 显示一级菜单，此时会返回至StartSMS类中的一级菜单处理流程
				showLoginMenu();
				break;
			}
			
			System.out.print("输入错误，请重新输入数字：");
			flag = false;
		} while (!flag);
	}
 
	/**
	 * 显示三级菜单-客户信息管理，并处理所有客户信息管理的流程
	 * 
	 */
	public void showCustMMenu() {
		System.out.println("购物管理系统 > 客户信息管理\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 显 示 所 有 客 户 信 息\n");
		System.out.println("\t\t\t\t 2. 添 加 客 户 信 息\n");
		System.out.println("\t\t\t\t 3. 修 改 客 户 信 息\n");
		System.out.println("\t\t\t\t 4. 查 询 客 户 信 息\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		do {
			// 创建客户信息管理对象，并设置数据，这里的数据还是原始的那些数据
			CustManagement custmanagement = new CustManagement();
			custmanagement.setGoodsName(getGoodsName());
			custmanagement.setGoodsPrice(getGoodsPrice());
			custmanagement.setCustNo(getCustNo());
			custmanagement.setCustBirth(getCustBirth());
			custmanagement.setCustScore(getCustScore());
			String s = scanner.next();
			
			// 客户选择"显示所有客户信息"
			if (s.equals("1")) {
				custmanagement.show();
				break;
			}
			
			// 客户选择"添加客户信息"
			if (s.equals("2")) {
				custmanagement.add();
				break;
			}
			
			// 客户选择"修改客户信息"
			if (s.equals("3")) {
				custmanagement.modify();
				break;
			}
			
			// 客户选择"查询客户信息"
			if (s.equals("4")) {
				custmanagement.search();
				break;
			}
			
			// 客户选择"返回上一级菜单"
			if (s.equals("n")) {
				showMainMenu();
				break;
			}
			
			System.out.println("输入错误, 请重新输入数字：");
			flag = false;
		} while (!flag);
	}
 
	/**
	 * 显示三级菜单-真情回馈，并处理所有真情回馈的流程
	 * 
	 */
	public void showSendMenu() {
		System.out.println("购物管理系统 > 真情回馈\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.println("\t\t\t\t 1. 幸 运 大 放 送\n");
		System.out.println("\t\t\t\t 2. 幸 运 抽 奖\n");
		System.out.println("\t\t\t\t 3. 生 日 问 候\n");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
		System.out.print("请选择,输入数字或按'n'返回上一级菜单:");
		Scanner scanner = new Scanner(System.in);
		
		// 创建礼物管理对象，并设置数据，这里的数据还是原始的那些数据
		GiftManagement giftmanagement = new GiftManagement();
		giftmanagement.setGoodsName(getGoodsName());
		giftmanagement.setGoodsPrice(getGoodsPrice());
		giftmanagement.setCustNo(getCustNo());
		giftmanagement.setCustBirth(getCustBirth());
		giftmanagement.setCustScore(getCustScore());
		
		boolean flag = true;
		do {
			String s = scanner.next();
			
			// 客户选择"幸运大放送"
			if (s.equals("1")) {
				giftmanagement.sendGoldenCust();
				break;
			}
			
			// 客户选择"幸运抽奖"
			if (s.equals("2")) {
				giftmanagement.sendLuckyCust();
				break;
			}
			
			// 客户选择"生日问候"
			if (s.equals("3")) {
				giftmanagement.sendBirthCust();
				break;
			}
			
			// 客户选择"返回上一级菜单"
			if (s.equals("n")) {
				showMainMenu();
				break;
			}
			
			System.out.println("输入错误, 请重新输入数字：");
			flag = false;
		} while (!flag);
	}
 
	
}
