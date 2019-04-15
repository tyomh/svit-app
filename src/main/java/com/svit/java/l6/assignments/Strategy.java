package com.svit.java.l6.assignments;

interface eatStrategy {
	void eat();
}

class RiceStrategy implements eatStrategy {
	public void eat() {
		System.out.println("eating rice");
	}
}

class NoodleStrategy implements eatStrategy {
	public void eat() {
		System.out.println("eating noodle");
	}
}

class Hungry {
	public void fightHungry(eatStrategy e) {
		e.eat();
	}
}

public class Strategy {
	public static void main(String[] args) {
		Hungry hungry = new Hungry();
		eatStrategy rice = new RiceStrategy();
		eatStrategy noodle = new NoodleStrategy();
		hungry.fightHungry(rice);
		hungry.fightHungry(noodle);
	}	
}
