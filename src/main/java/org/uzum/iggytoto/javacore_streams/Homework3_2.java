package org.uzum.iggytoto.javacore_streams;

import org.uzum.iggytoto.javacore_streams.model.Person;
import org.uzum.iggytoto.javacore_streams.model.PersonBuilder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс для реализации домашнего задания номер три, часть 2.
 */
public class Homework3_2 {
    public static void main(String[] args) {
        Homework3_2 hw = new Homework3_2();

        Person john = PersonBuilder.getJohn();
        Person bob = PersonBuilder.getBob();
        Person bob2 = PersonBuilder.getBob();
        Person anthony = PersonBuilder.getAnthony();
        List<Person> persons = Arrays.asList(john, bob, bob2, anthony);

        Map<Integer, List<Person>> result = hw.groupByAge(persons, 18, true);

        result.forEach((key, value) -> System.out.println(key + " " + value));




    }

    /**
     * Реализовать метод при помощи {@link java.util.stream.Stream} который:
     * - группирует заданых персон по возрасту
     * - фильтрует по минимальному возрасту
     * @param persons - заданный список персон
     * @param minimalAgeFilter - указанный минимальный возраст
     * @param removeDupes - флаг отвечающий за исключение дубликатов из результата
     * @return словарь где ключ возраст а значение лист персон с этим хобби
     */





    public Map<Integer, List<Person>> groupByAge(List<Person> persons, int minimalAgeFilter, boolean removeDupes) {
        Set<Person> seen = new HashSet<>();

        Map<Integer,List<Person>> groupedPerson = persons.stream()
                .filter(person -> person.getAge() >= minimalAgeFilter)
                .filter(person -> !removeDupes || seen.add(person)) // Добавляем элемент в seen и фильтруем, если removeDupes равно false или элемент успешно добавлен в seen
                .collect(Collectors.groupingBy(Person::getAge)); // Map<Integer, List<Person>>
        return groupedPerson;
    }
}





