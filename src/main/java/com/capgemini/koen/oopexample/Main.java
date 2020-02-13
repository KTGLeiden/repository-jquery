package com.capgemini.koen.oopexample;

public class Main {
    public static void main(String[] args) {
        Person mahdi = new Person("Mahdi", 33, "No, not yet");
        Person koen = new Person("Koen", 26, "I brought cake!");
        Person shahin = new Person("Shahin", 32, "It's valentines day! I brought chocolate");

        shahin.celebrateBirthday();
        koen.celebrateBirthday();
        mahdi.celebrateBirthday();

    }
}
