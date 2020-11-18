package niit.java.project1.biz;

import java.util.Scanner;

/**
 * 处理顾客购买商品以及结算的类
 * 
 * @author
 * 
 */
public class Pay {
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
	public Pay() {
	}
 
	
//有参构造函数
	public Pay(String[] goodsName, double[] goodsPrice, int[] custNo, String[] custBirth, int[] custScore) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.custNo = custNo;
		this.custBirth = custBirth;
		this.custScore = custScore;
	}

	/**
	 * 根据会员信息确定折扣率
	 * 
	 * @param i
	 * @param ai
	 * @param ai1
	 * @return
	 */
	public double getDiscount(int i, int ai[], int ai1[]) {
		
		int j = -1;
		int k = 0;
		
		do {
			if (k >= ai.length)
				break;
			
			if (i == ai[k]) {
				j = k;
				break;
			}
			k++;
		} while (true);
		
		double d;
		if (ai1[j] < 1000)
			d = 0.94999999999999996D;
		else if (1000 <= ai1[j] && ai1[j] < 2000)
			d = 0.90000000000000002D;
		else if (2000 <= ai1[j] && ai1[j] < 3000)
			d = 0.84999999999999998D;
		else if (3000 <= ai1[j] && ai1[j] < 4000)
			d = 0.80000000000000004D;
		else if (4000 <= ai1[j] && ai1[j] < 6000)
			d = 0.75D;
		else if (6000 <= ai1[j] && ai1[j] < 8000)
			d = 0.69999999999999996D;
		else
			d = 0.59999999999999998D;
		return d;
	}
 
	/**
	 * 该类的关键方法，用于处理购物和结算
	 * 
	 */
	public void calcPrice() {
		
		String s2 = "";
		double d1 = 0.0D;
		double d2 = 0.0D;
		int    l  = 0;
		double d4 = 0;
		
		System.out.println("购物管理系统 > 购物结算\n\n");
		System.out.println("*************************************");
		System.out.println("请选择购买的商品编号：");
		
		// 显示所有的可购买商品信息，这里的信息就是最初的那些初始化商品数据
		for (l = 0; l < goodsName.length && goodsName[l] != null; l++) {
			d4++;
			System.out.println((new StringBuilder()).append(d4).append(": ")
					.append(goodsName[l]).append("\t").toString());
		}
 
		System.out.println("*************************************\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("\t请输入会员号：");
		int i = scanner.nextInt();
		
		// 根据会员信息获取打折信息
		d4 = getDiscount(i, custNo, custScore);	
		
		String s1;
		do {
			System.out.print("\t请输入商品编号：");
			int j = scanner.nextInt();
			System.out.print("\t请输入数目：");
			int k = scanner.nextInt();
			
			double d = goodsPrice[j - 1];
			String s = goodsName[j - 1];
			d1 += d * (double) k;
			s2 = (new StringBuilder()).append(s2).append("\n").append(s)
					.append("\t").append("￥").append(d).append("\t\t")
					.append(k).append("\t\t").append("￥")
					.append(d * (double) k).append("\t").toString();
			
			System.out.print("\t是否继续（y/n）");
			s1 = scanner.next();
			
		} while (s1.equals("y"));
		
		d2 = d1 * d4;	// 打折后的总价
		
		System.out.println("\n");
		System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊消费清单＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
		System.out.println("物品\t\t单价\t\t个数\t\t金额\t");
		System.out.print(s2);
		System.out.println((new StringBuilder()).append("\n折扣：\t").append(d4).toString());
		System.out.println((new StringBuilder()).append("金额总计:\t￥").append(d2).toString());
		System.out.print("实际交费:\t￥");
		double d3 = scanner.nextDouble();
		System.out.println((new StringBuilder()).append("找钱:\t￥").append(d3 - d2).toString());
		int i1 = ((int) d2 / 100) * 3;
		int j1 = 0;
		do {
			if (j1 >= custNo.length)
				break;
			if (custNo[j1] == i) {
				custScore[j1] = custScore[j1] + i1;
				System.out.println((new StringBuilder()).append("本次购物所获的积分是： ")
						.append(i1).toString());
				break;
			}
			j1++;
		} while (true);
		
		System.out.print("\n请'n'返回上一级菜单:");
		if (scanner.next().equals("n")) {
			// 返回上一级菜单，这里新建了一个菜单对象，只是在用户看来其实还是同样的处理流程，
			// 不过对于程序来说却又开始了一个新的二级菜单处理流程
			Menu menu = new Menu();
			menu.setGoodsName(this.getGoodsName());
			menu.setGoodsPrice(this.getGoodsPrice());
			menu.setCustNo(this.getCustNo());
			menu.setCustBirth(this.getCustBirth());
			menu.setCustScore(this.getCustScore());
			menu.showMainMenu();
		}
	}
 
	
}
