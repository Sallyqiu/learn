package com.atguigu.java8;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * lambda表达式的基础语法； java8中引入了一个新的操作符“->”， 该操作符成为箭头操作符或lambda操作符
 * 箭头操作符将lambda表达式拆分成两部分
 * 
 * 左侧：lambda表达式的参数列表
 * 右侧：lambda表达式中所需要执行的功能， 即lambda体 
 * 语法格式一： 无参数，无返回值
 * ()->System.out.println("hello lambda")
 * 语法格式二： 有一个参数，无返回值
 * 语法格式三： 若只有一个参数，小括号可以省略不写
 * 语法格式四：有两个以上的参数，有返回值，并且lambda体中有多条语句
 * 语法格式五，若lambda体中只有一条语句，return和大括号都可以省略不写
 * 语法格式六：lambda表达式，参数数据类型可以不写，JVM可以根据上下文推断
 * 
 * 
 * 二；lambda表达式需要函数式接口的支持
 * 函数式接口： 接口中只有一个抽象方法的接口，成为函数式接口，可以使用注解@FunctionalInterface修饰
 * 可以以检查是不是函数式接口
 */ 
public class TestLambda2 {
	
	@Test
	public void test1() {
		
		int num =0; //jdk1.7前，必须是final
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Hello World"+num);
			}
		};
		
		r.run();
		
		System.out.println("=========="); 
		
		Runnable r1 = ()->System.out.println("Hello lambda"+num);
		r1.run();
	}
	
	@Test
	
	public void test2() {
		Consumer<String> con = x->System.out.println(x);
		con.accept("啦啦啦啦");
	}
	
	@Test
	public void test3() {
		Comparator<Integer> com = (x,y)->{System.out.println("hehhe");
		return Integer.compare(x, y); 
		};
	}
	
	@Test
	public void test4() {
		Comparator<Integer> com = (x,y)-> Integer.compare(x, y); 
		}
		
		
   @Test
   public void test5() {
	   
	//List<String> list = new ArrayList<>();
	
	show(new HashMap<>());
	   
   }
	public void show(Map<String, Integer> map) {}
	
	//需求： 对一个数字进行运算
	@Test
	public void test6() {
		
		Integer num=operation(100,(x)->x*x);
		System.out.println(num);
		
		System.out.println(operation(200,(y)->y+200));
		
		
	
		
	}
	
	public Integer operation(Integer num, MyFun mf) {
		return mf.getValue(num);
	}

}
