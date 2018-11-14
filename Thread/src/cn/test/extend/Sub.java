package cn.test.extend;

public class Sub extends Fu{
	int a = 6;
	public void test(){
		System.out.println("Zi");
	}
	public void showa(){
		System.out.println(super.a);
	}
}
