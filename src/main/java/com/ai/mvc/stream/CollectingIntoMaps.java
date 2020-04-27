package com.ai.mvc.stream;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {

    public static class Person {
        private Integer id;
        private String name;

        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }


        public String getName() {
            return name;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"), new Person(1003, "Mary"));
    }

    public static void main(String[] args) {
//        Locale

        Map<Integer, String> idToName = people()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);
    }
}
