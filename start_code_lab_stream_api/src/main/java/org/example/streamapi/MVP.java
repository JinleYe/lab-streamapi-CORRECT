package org.example.streamapi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MVP {

    /*
        Convert a List<String> to an object stream and for each element -> System,out.println.
     */

    public void printNames(List<String> names) {
        // Implement me :)
        Stream<String> convertedStream = names.stream();
        convertedStream.forEach(name -> System.out.println(name));
    }

    /*
        Given a List<Integers>, return a List<Integer> with even numbers.
     */
    public List<Integer> returnEvenNumbers(List<Integer> numbers) {
        // Implement me :)
        List<Integer> evenNumber = numbers.stream()
                .filter(n -> n%2 == 0)
                .toList();
        return evenNumber;
    }

    /*
        Given an int [], double the value of each int and return an int [].
    */
    public int[] doubleInts(int[] numbers) {
        // Implement me :)
        int[] doubleValue = Arrays.stream(numbers)
                .map((number) -> number * 2)
                .toArray();
        return doubleValue;
    }

    /*
        Given a String, return a List<String>, all caps.
     */
    public List<String> splitToAllCapsList(String input) {
        // Implement me :)
        List<String> allCaps = Arrays.stream(input.split(""))
                .map(eachChar -> eachChar.toUpperCase())
                .toList();
        return allCaps;
    }

    /*
    Given a list of animals:
     - filter the ones that start with a given letter
     - return sorted List<String>, all caps.
    */
    public List<String> filterByFirstLetterAndOrder(List<String> list, String letter) {
        // Implement me :)
        Predicate<String> startWithLetter = animal -> animal.charAt(0) == letter.charAt(0);
        List<String> result = list.stream()
                .filter(startWithLetter)
                .sorted()
                .map(eachChar -> eachChar.toUpperCase())
                .toList();
        return result;
    }

    /*
        Given a list of words, return elements that:
         - are shorter than the given number and
         - start with a given letter.
    */
    public List<String> filterWords(List<String> words, int maxLength, String firstLetter) {
        // Implement me :)

        Predicate<String> shorterThanMaxLength = word -> word.length() < maxLength;
        Predicate<String> startWithFirstLetter = word -> word.charAt(0) == firstLetter.charAt(0);
        List<String> result = words.stream()
                .filter(shorterThanMaxLength.and(startWithFirstLetter))
                .toList();
        return result;
    }
}