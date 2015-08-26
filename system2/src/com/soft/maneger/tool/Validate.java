package com.soft.maneger.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	
	public static boolean excute(String rule,String content){
		Pattern pattern=Pattern.compile(rule);//利用验证规则创建Pattern对象
		 Matcher matcher=pattern.matcher(content);//利用验证内容获得Matcher对象
	   return matcher.matches();//返回验证结果
	}
	
	
	public static void main(String[] args) {
		String rule="[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
		String a="201h-4-5";
		Pattern pattern=Pattern.compile(rule);
		Matcher matcher=pattern.matcher(a);
		System.out.println(matcher.matches());
	}
}
