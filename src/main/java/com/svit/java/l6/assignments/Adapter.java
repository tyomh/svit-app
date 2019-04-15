package com.svit.java.l6.assignments;

// Java adapter design pattern

interface GermanStandard {
	void power();
}

interface ChinaStandard {
	void power();
}

class GermanSocket implements GermanStandard {
	public void power() {
		System.out.println("German");
	}
}

class ChinaSocket implements ChinaStandard {
	public void power() {
		System.out.println("China");
	}
}

public class Adapter implements GermanStandard{

    private ChinaStandard cs;
    Adapter(ChinaStandard cs) {
    	this.cs = cs;
    }
    
    public void power() {
    	cs.power();
    }
    
    public static void main(String[] args) {
    	GermanStandard germanSocket = new GermanSocket();
    	ChinaStandard chinaSocket = new ChinaSocket();
    	
    	GermanStandard adapter = new Adapter(chinaSocket);
    	
    	adapter.power();
    } 
}
