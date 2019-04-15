package com.svit.java.l6.assignments;

import java.lang.reflect.*;

import com.svit.java.l6.SingletonEagerDemo;

public class DestroySingletonWithReflection { 
	public static void main(String[] args) {
		SingletonEagerDemo instance1 = SingletonEagerDemo.getSingletonObject();
		SingletonEagerDemo instance2 = null;
		
		try {
			Constructor cons = SingletonEagerDemo.class.getDeclaredConstructor();
			cons.setAccessible(true);
			instance2 = (SingletonEagerDemo) cons.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(instance1.equals(instance2));
		
	}
}
