package com.soft.maneger.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	
	public static boolean excute(String rule,String content){
		Pattern pattern=Pattern.compile(rule);//������֤���򴴽�Pattern����
		 Matcher matcher=pattern.matcher(content);//������֤���ݻ��Matcher����
	   return matcher.matches();//������֤���
	}
	
	
	public static void main(String[] args) {
		String rule="[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
		String a="201h-4-5";
		Pattern pattern=Pattern.compile(rule);
		Matcher matcher=pattern.matcher(a);
		System.out.println(matcher.matches());
	}
}
