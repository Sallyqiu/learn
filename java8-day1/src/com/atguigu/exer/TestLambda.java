package com.atguigu.exer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.atguigu.java8.Employee;
import com.atguigu.java8.MyFunction2;

public class TestLambda {
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "����", 18, 9999.99),
			new Employee(102, "����", 59, 6666.66),
			new Employee(103, "����", 28, 3333.33),
			new Employee(104, "����", 8, 7777.77),
			new Employee(105, "����", 38, 5555.55)
	);
	@Test
	
	public void test1() {
		Collections.sort(emps, (e1,e2)->{
			if(e1.getAge()==e2.getAge()) {
				return e1.getName().compareTo(e2.getName());
			}else {
				return -Integer.compare(e1.getAge(),e2.getAge());
			}
		});
		
		for (Employee emp:emps) {
			System.out.println(emp);
			
		}
	}
	
	@Test
	
	public void test2() {
		String trimstr=strHander("\t\t\t  �Ǻ�",(str)->str.trim());
		System.out.println(trimstr);
		String upper=strHander("abc",(str)->str.toUpperCase());
		System.out.println(upper);
	}
	//���ڴ����ַ����ķ���
	public String strHander(String str, MyFun mf) {
		return mf.getValue(str);
	}
	
	//��������Long�����ݽ��д���
		public void op( Long l1, Long l2, MyFunction2<Long,Long> mf) {
			
		System.out.println(mf.getValue(l1, l2));
			
		}
		
		@Test
		public void test3() {
			op(100L,200L, (x,y)->x+y);
		}

}
