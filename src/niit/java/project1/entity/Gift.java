package niit.java.project1.entity;

public class Gift {
//属性
	public String name ;	// 礼物名字
	public double price;	// 礼物价格
	//无参构造函数
	public Gift() {
	}
	
	/**
	 * 根据礼物对象的变量返回礼物的全部信息
	 * 
	 */
	public String toString() {
		String info="一个价值"+this.price+"的"+this.name;
		return info;
	}
	

}

