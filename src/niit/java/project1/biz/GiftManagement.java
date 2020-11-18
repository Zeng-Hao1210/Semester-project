package niit.java.project1.biz;

import java.util.Scanner;

import niit.java.project1.entity.Gift;

/**
 * 礼物管理类
 * 
 * @author
 * 
 */
public class GiftManagement {
//属性
	public String 	goodsName [];	// 商品的名称
	public double 	goodsPrice[];	// 商品的价格
	public int 	custNo	  [];	// 顾客的会员号
	public String 	custBirth [];	// 顾客的生日
	public int 	custScore [];	// 顾客的积分
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

	/**
	 * 空构造方法
	 * 
	 */
	public GiftManagement() {
	}
 
	/**
	 * 设置礼物管理类的数据信息
	 * 
	 * @param as
	 * @param ad
	 * @param ai
	 * @param as1
	 * @param ai1
	 */
	/*
	 * public void setData(String as[], double ad[], int ai[], String as1[], int
	 * ai1[]) { goodsName = as; goodsPrice = ad; custNo = ai; custBirth = as1;
	 * custScore = ai1; }
	 */
 
	/**
	 * 返回上一级菜单，即二级菜单-真情回馈菜单
	 * 
	 */
	public void returnLastMenu() {
		
		System.out.print("\n\n请按'n'返回上一级菜单:");
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		do
			if (scanner.next().equals("n")) {
				// 返回上一级菜单，这里新建了一个菜单对象，只是在用户看来其实还是同样的处理流程，
				// 不过对于程序来说却又开始了一个新的二级菜单处理流程
				Menu menu = new Menu();
				menu.setGoodsName(this.getGoodsName());
				menu.setGoodsPrice(this.getGoodsPrice());
				menu.setCustNo(this.getCustNo());
				menu.setCustBirth(this.getCustBirth());
				menu.setCustScore(this.getCustScore());			
				menu.showSendMenu();
			} else {
				System.out.print("输入错误, 请重新'n'返回上一级菜单：");
				flag = false;
			}
		while (!flag);
	}
 
	/**
	 * 生日问候
	 * 
	 */
	public void sendBirthCust() {
		
		System.out.println("购物管理系统 > 生日问候\n\n");
		System.out.print("请输入今天的日期(月/日<用两位表示>)：");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(s);
		
		String  s1   = "";
		boolean flag = false;
		for (int i = 0; i < custBirth.length; i++)
			if (custBirth[i] != null && custBirth[i].equals(s)) {
				s1 = (new StringBuilder()).append(s1).append(custNo[i]).append(
						"\n").toString();
				flag = true;
			}
 
		// 这里的礼物是固定的，所以没有用礼物类
		if (flag) {
			System.out.println("过生日的会员是：");
			System.out.println(s1);
			System.out.println("恭喜！获赠MP3一个！");
		} else {
			System.out.println("今天没有过生日的会员！");
		}
		
		// 返回上一级菜单
		returnLastMenu();
	}
 
	/**
	 * 幸运抽奖，注意这里是随机的抽奖，所以需要随机数，只需要自己制定一个抽奖规则就可以
	 * 
	 */
	public void sendLuckyCust() {
		
		System.out.println("购物管理系统 > 幸运抽奖\n\n");
		System.out.print("是否开始（y/n）：");
		Scanner scanner = new Scanner(System.in);
		
		if (scanner.next().equals("y")) {
			
			int     i    = (int) (Math.random() * 10D);	// 产生一个随机数
			String  s    = "";
			boolean flag = false;
			
			for (int k = 0; k < custNo.length && custNo[k] != 0; k++) {
				// 拿随机数与顾客会员号的相应结果进行比较，从而判断是否有顾客中奖
				int j = (custNo[k] / 100) % 10;
				if (j == i) {
					s = (new StringBuilder()).append(s).append(custNo[k])
							.append("\t").toString();
					flag = true;
				}
			}
 
			// 固定的奖品，所以不需要礼物类
			if (flag)
				System.out.println((new StringBuilder()).append("幸运客户获赠MP3：")
						.append(s).toString());
			else
				System.out.println("无幸运客户。");
		}
		
		// 返回上一级菜单
		returnLastMenu();
	}
 
	/**
	 * 幸运大放送，取积分最高的会员作为幸运者，送其奖品
	 * 
	 */
	public void sendGoldenCust() {
		
		System.out.println("购物管理系统 > 幸运大放送\n\n");
		int i = 0;
		int j = custScore[0];
		for (int k = 0; k < custScore.length && custScore[k] != 0; k++) {
			// 找到积分最高的会员
			if (custScore[k] > j) {
				j = custScore[k];
				i = k;
			}
		}
 
		System.out.println((new StringBuilder()).append("具有最高积分的会员是： ").append(
				custNo[i]).append("\t").append(custBirth[i]).append("\t")
				.append(custScore[i]).toString());
		
		// 创建礼物类，并对礼物信息进行设置，这里的礼物是固定的信息
		Gift gift = new Gift();
		gift.name = "苹果笔记本电脑";
		gift.price = 12000D;
		System.out.print("恭喜！获赠礼品： ");
		System.out.println(gift);
		
		// 返回上一级菜单
		returnLastMenu();
	}
 

}

