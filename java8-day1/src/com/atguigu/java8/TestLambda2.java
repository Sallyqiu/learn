package com.atguigu.java8;

import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * lambda���ʽ�Ļ����﷨�� java8��������һ���µĲ�������->���� �ò�������Ϊ��ͷ��������lambda������
 * ��ͷ��������lambda���ʽ��ֳ�������
 * 
 * ��ࣺlambda���ʽ�Ĳ����б�
 * �Ҳࣺlambda���ʽ������Ҫִ�еĹ��ܣ� ��lambda�� 
 * �﷨��ʽһ�� �޲������޷���ֵ
 * ()->System.out.println("hello lambda")
 * �﷨��ʽ���� ��һ���������޷���ֵ
 * �﷨��ʽ���� ��ֻ��һ��������С���ſ���ʡ�Բ�д
 * �﷨��ʽ�ģ����������ϵĲ������з���ֵ������lambda�����ж������
 * �﷨��ʽ�壬��lambda����ֻ��һ����䣬return�ʹ����Ŷ�����ʡ�Բ�д
 * �﷨��ʽ����lambda���ʽ�������������Ϳ��Բ�д��JVM���Ը����������ƶ�
 * 
 * 
 * ����lambda���ʽ��Ҫ����ʽ�ӿڵ�֧��
 * ����ʽ�ӿڣ� �ӿ���ֻ��һ�����󷽷��Ľӿڣ���Ϊ����ʽ�ӿڣ�����ʹ��ע��@FunctionalInterface����
 * �����Լ���ǲ��Ǻ���ʽ�ӿ�
 */ 
public class TestLambda2 {
	
	@Test
	public void test1() {
		
		int num =0; //jdk1.7ǰ��������final
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
		con.accept("��������");
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
	
	//���� ��һ�����ֽ�������
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
