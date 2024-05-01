package com.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListInterviewQuestion {
public static void main(String[] args) {
	List<Integer> integers = new ArrayList<Integer>();
	IntStream.range(1, 100000).forEach(i->{
		integers.add(i);
	});
	IntStream.range(1, 1000003333).parallel().forEach(i->{
		integers.add(i);
	});
}
}
