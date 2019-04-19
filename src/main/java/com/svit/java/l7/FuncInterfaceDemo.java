package com.svit.java.l7;

/**
 * 
 * Code is for study and personal use purpose, not for commercial use.
 * 
 * @author sv-it.org
 *
 */
interface FuncInterface {
	// functional interface (An interface with single abstract method )
	void abstractFun(int x);

	// A non-abstract (or default) function
	default void normalFun() {
		System.out.println("Hello");
	}
}

public class FuncInterfaceDemo {

	public static void main(String[] args) {
		// implement a user defined functional interface.
		FuncInterface fobj = x -> System.out.println(2 * x);

		// call above lambda expression
		fobj.abstractFun(5);
	}

}
