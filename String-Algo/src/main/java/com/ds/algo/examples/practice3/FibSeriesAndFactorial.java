package com.ds.algo.examples.practice3;

import javafx.util.Pair;

import java.math.BigInteger;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibSeriesAndFactorial {

    public static void main(String[] args) {

        Pair<BigInteger, BigInteger> fib = new Pair<>(BigInteger.ONE, BigInteger.ONE);
        UnaryOperator<Pair<BigInteger, BigInteger>> fibOperator = (Pair<BigInteger, BigInteger> x) -> {
            return new Pair<>(x.getValue(), x.getKey().add(x.getValue()));
        };

        String fibSeries = Stream.iterate(fib, fibOperator)
                .map(Pair::getKey)
                .limit(20)
                .map(BigInteger::toString)
                .collect(Collectors.joining(","));

        System.out.println(fibSeries);


    }
}
