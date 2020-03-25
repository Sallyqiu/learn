package com.atguigu.java8;
/*
 * ��Lambda���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ�á��������á�
 * ���������Ϊ����������Lambda���ʽ������һ�ֱ�����ʽ��
 * 
 * ��Ҫ�������﷨��ʽ��
 * ע�⣺
 * lambda���е��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ��
 * ��lambda�����б��еĵ�һ��������ʵ�������ĵ����ߣ����ڶ���������ʵ�������Ĳ���ʱ������ʹ��className ::method
 * ���󣺣�ʵ��������
 * �ࣺ����̬������
 * �ࣺ��ʵ��������
 * 
 * ����������
 * ��ʽ��
 * ClassName::new
 * ע�⣺��Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��г��󷽷��Ĳ����б���һ��
 * 
 * �������ã�
 * Type::new
 */

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class TestMethodRef {
	//��������
	
	@Test
	public void test7() {
		Function<Integer, String[]> fun = (x)->new String[x];
				String[] str=fun.apply(10);
				System.out.println(str.length);
				
				Function<Integer,String[]> fun2 = String[]::new;
				String[] str2= fun2.apply(20);
				System.out.println(str2.length);
		
	}
	
	//����������
	@Test
	public void test5() {
		Supplier<Employee> sup = ()->new Employee();
		sup.get();
		
		//���������÷�ʽ
		Supplier<Employee> sup2= Employee::new;
		Employee emp =sup2.get();
		System.out.println(emp);
	}
	
	@Test
	public void test6() {
		Function<Integer, Employee> fun =(x)->new Employee(x);
		Function<Integer ,Employee> fun2 = Employee::new;
		Employee emp = fun2.apply(101);
		System.out.println(emp);
		
		BiFunction<Integer, Integer,Employee> bf = Employee::new;
	}
	//���󣺣�ʵ��������
	@Test
	public void test1() {
		Consumer<String> con = (x)->System.out.println(x);
		
		PrintStream ps =System.out;
		Consumer<String> con1 = ps::println;
		
		Consumer<String> con2=System.out::println;
		con2.accept("abcd1234");
	}
		
		@Test
		public void test2(){
			Employee emp = new Employee();
			Supplier<String> sup=()->emp.getName();
			String str = sup.get();
			System.out.println(str);
			
			Supplier<Integer> sup2= emp::getAge;
			Integer num =sup2.get();
			System.out.println(num);
		
	}
		
		@Test
		public void test3() {
			//�ࣺ����̬����
			Comparator<Integer> com = (x,y)->Integer.compare(x,y);
			Comparator<Integer> com1 = Integer::compare;
			
		}
		
		//�ࣺ��ʵ��������
		@Test
		public void test4() {
			BiPredicate<String, String> bp = (x,y)->x.equals(y);
			BiPredicate<String,String> bp2 = String::equals;
		}

}
