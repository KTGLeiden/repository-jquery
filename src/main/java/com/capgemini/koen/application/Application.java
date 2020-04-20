package com.capgemini.koen.application;

import com.capgemini.koen.application.lambdas.MyFunctionalInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

@SpringBootApplication
public class Application {

	public static Predicate<String> predicate;

	public static void main(String[] args) {
		test();
		SpringApplication.run(Application.class, args);
	}

	public static void test() {
		Integer x = null;
		int y = x;
		System.out.println(y);
	}


}
