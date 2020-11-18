package niit.java.project1.entity;

public class Data {
	 /*====================定义该类所拥有的变量====================*/
	private String 	goodsName [];	// 商品的名称
	private double 	goodsPrice[];	// 商品的价格
	private int 	custNo	  [];	// 顾客的会员号
	private String 	custBirth [];	// 顾客的生日
	private int 	custScore [];	// 顾客的积分
	private Manager 	manager	;	// 管理员类，仅仅存储了管理员的用户名和密码
	
	
	
//无参构造方法
	public Data() {
		goodsName 	= new String[50] ;
		goodsPrice 	= new double[50] ;
		custNo 		= new int[100]	 ;
		custBirth 	= new String[100];
		custScore 	= new int[100]   ;
		manager 	= new Manager()  ;
	}
	
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


	public Manager getManager() {
		return manager;
	}

	

	public void setManagerUsername(String name) {
		
		this.manager.username=name;
	}
	public void setManagerPassword(String pw) {
	
		this.manager.password=pw;
	}


	/**
	 * 初始化该类的数据
	 * 
	 */
	public void initial() {
		
		/*====================添加了初始的7种商品信息====================*/
		goodsName [0] = "addidas运动鞋";
		goodsPrice[0] = 880D;
		goodsName [1] = "Kappa网球裙";
		goodsPrice[1] = 200D;
		goodsName [2] = "网球拍";
		goodsPrice[2] = 780D;
		goodsName [3] = "addidasT恤";
		goodsPrice[3] = 420.77999999999997D;
		goodsName [4] = "Nike运动鞋";
		goodsPrice[4] = 900D;
		goodsName [5] = "Kappa网球";
		goodsPrice[5] = 45D;
		goodsName [6] = "KappaT恤";
		goodsPrice[6] = 245D;
		
		/*====================添加了初始的7个顾客信息====================*/
		custNo	 [0] = 1900;
		custBirth[0] = "08/05";
		custScore[0] = 2000;
		custNo	 [1] = 1711;
		custBirth[1] = "07/13";
		custScore[1] = 4000;
		custNo	 [2] = 1623;
		custBirth[2] = "06/26";
		custScore[2] = 5000;
		custNo 	 [3] = 1545;
		custBirth[3] = "04/08";
		custScore[3] = 2200;
		custNo	 [4] = 1464;
		custBirth[4] = "08/16";
		custScore[4] = 1000;
		custNo	 [5] = 1372;
		custBirth[5] = "12/23";
		custScore[5] = 3000;
		custNo	 [6] = 1286;
		custBirth[6] = "12/21";
		custScore[6] = 10080;
	}
 
	
}
