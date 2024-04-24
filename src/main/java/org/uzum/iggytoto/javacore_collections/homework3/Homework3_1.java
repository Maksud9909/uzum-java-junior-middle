package org.uzum.iggytoto.javacore_collections.homework3;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс для реализации домашнего задания номер три, часть 1.
 */
public class Homework3_1 {
    public static void main(String[] args) {
            Homework3_1 homework = new Homework3_1();

            // Test case 1: Count words in a simple sentence
            String text1 = "Hello, world! This is a test.";
            Map<String, Integer> result1 = homework.countWords(text1);
            System.out.println("Test case 1:");
            System.out.println("Input: " + text1);
            System.out.println("Output: " + result1);
            System.out.println();

            // Test case 2: Count words in a sentence with special characters
            String text2 = "Hello, world! This is a test. 123,456?";
            Map<String, Integer> result2 = homework.countWords(text2);
            System.out.println("Test case 2:");
            System.out.println("Input: " + text2);
            System.out.println("Output: " + result2);
            System.out.println();

            // Test case 3: Count words in an empty string
            String text3 = "";
            Map<String, Integer> result3 = homework.countWords(text3);
            System.out.println("Test case 3:");
            System.out.println("Input: " + text3);
            System.out.println("Output: " + result3);
            System.out.println();

            // Test case 4: Count words in a string with only digits and punctuation marks
            String text4 = "12345 67890!@#$%^&*()";
            Map<String, Integer> result4 = homework.countWords(text4);
            System.out.println("Test case 4:");
            System.out.println("Input: " + text4);
            System.out.println("Output: " + result4);
            System.out.println();
    }






    /**
     * Для решения этой задачи было использовано regex, Stream API а также параллельный стрим
     *
     * @param text - заданный текст
     * @return - словарь слов и количество их появлений в данном тексте
     */
    public Map<String, Integer> countWords(String text){
        if (text == null || text.isEmpty()) {
            return null; // Или более подходящее значение по умолчанию
        }

        // Используем параллельный стрим для обработки текста
        return Arrays.stream(text.split("\\P{L}+"))
                .parallel() // Включаем параллельность
                .map(String::toLowerCase)
                .collect(Collectors
                        .groupingByConcurrent(Function.identity(), ConcurrentHashMap::new, Collectors.summingInt(w -> 1)));
    }




}



