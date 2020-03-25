package com.atguigu.java8;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * Java8 ���õ��Ĵ���ĺ���ʽ�ӿ�
 * Consumer<T> :�����ͽӿ�
 *  void accept(T t);
 *  
 *  Supplier<T>:�����ͽӿ�
 *      T get();
 *  Function<T,R>:�����ͽӿ�
 *   R apply(T t);
 *  Predicate<T>:�����ͽӿ�
 *     boolean test(T t);
 */
public class TestLambda3 {
	
	//Consumer<T>�����ͽӿ�
	@Test
	public void test1() {
		happy(10000,(m)->System.out.println("���Ǹո�ϲ��da bao jian"+m+"Ԫ"));
	}
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	//Supplier<T>�����ͽӿ�
	@Test
	public void test2() {
	List<Integer> numList=	getNumList(10,()->(int)(Math.random()*100));
		for(Integer num:numList) {
			System.out.println(num);
		}
		
	}
	//���� ����һЩ֤�飬�����뼯����
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<num;i++) {
		Integer n=	sup.get();
		list.add(n);
		}
		
		return list;
		 
	}
	
	//Function<T,R>�����ͽӿ�
	
	//���ڴ����ַ���
	public String strHander(String str, Function<String,String> fun) {
		return fun.apply(str);
	}
	 
	@Test
	public void test3() {
		String newStr= strHander("\t\t\t�ǺǺ�",(str)->str.trim());
		System.out.println(newStr);
		String newStr1=strHander("�������ǺǺ�",(str)->str.substring(2, 5));
		System.out.println(newStr1);
		
	}
	
	//Predicate<T> �����ͽӿ�
	//���� �������������ַ�����ȡ������ӵ�������
	@Test
	public void test4() {
		List<String> list = Arrays.asList("hello","nihao","ok");
		List<String> strList =filterStr(list,(s)->s.length()>3);
		for(String str: strList) {
			System.out.println(str);
		}
		
	}
	public List<String> filterStr(List<String> list, Predicate<String> pre){
		List<String> strList = new ArrayList<>();
		for(String str:list) {
			if(pre.test(str)) {
				strList.add(str );
			}
		}
		return strList;
	}
	
	

}
