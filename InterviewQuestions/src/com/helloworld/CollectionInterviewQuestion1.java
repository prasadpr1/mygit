package com.helloworld;

import java.util.TreeSet;

public class CollectionInterviewQuestion1 {
public static void main(String[] args) {
	TreeSet<StringBuilder> builders = new TreeSet<>();
	builders.add(new StringBuilder());
	builders.add(new StringBuilder());
	System.out.println(builders.size());//1
	TreeSet<String> set = new TreeSet<String>();
	set.add(null);
	System.out.println(set.size());//2
	set.add("helloworld");
	System.out.println(set.size());//3
	
}
	
}
