package com.svit.java.l6.assignments;

// Java Builder design pattern

public class Builder {
	// required params
    private String name;
    private int age;
    
    // optional params
    private String hobby;
    
    private Builder(BuilderHelper builder) {
    	this.name = builder.name;
    	this.age = builder.age;
    	this.hobby = builder.hobby;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getAge() {
    	return this.age;
    }
    
    public String getHobby() {
    	return this.hobby;
    }
    
    public static class BuilderHelper {
    	private String name;
    	private int age;
    	private String hobby;
    	
    	public BuilderHelper(String name, int age) {
    		this.name = name;
    		this.age = age;
    	}
    	
    	public BuilderHelper setHobby(String hobby) {
    		this.hobby = hobby;
    		return this;
    	}
    	
    	public Builder build() {
    		return new Builder(this);
    	}
    }
    
    public static void main(String[] args) {
    	Builder builder = new Builder.BuilderHelper("abc", 12).setHobby("surfing").build();
    	System.out.println(builder.getName());
    	System.out.println(builder.getHobby());
    	System.out.println(builder.getAge());
    }
}
