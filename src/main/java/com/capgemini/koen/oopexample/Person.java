package com.capgemini.koen.oopexample;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person() {}

    public Person(String name, int age, String birthdayMessage) {
        this.name = name;
        this.age = age;
        this.birthdayMessage = birthdayMessage;
    }

    public String birthdayMessage;

    public void celebrateBirthday() {
        // Increment age
        this.age = this.age + 1;
        // Print nice message
        System.out.println("Hi, I'm " + this.name + " and I'm turning " + this.age + "today. " + birthdayMessage);
    }

}
