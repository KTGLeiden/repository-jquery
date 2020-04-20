package com.capgemini.koen.application.lambdas;
// FUNCTIONAL INTERFACE!!
// WHY? BECAUSE WE ONLY HAVE ONE METHOD!
public interface MyPredicate<T> {
    boolean test(T data);
}
