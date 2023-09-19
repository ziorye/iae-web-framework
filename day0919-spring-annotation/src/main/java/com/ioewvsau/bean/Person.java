package com.ioewvsau.bean;

public class Person {
    // 1. fields

    public String name;
    public int age;

    // end fields
    // ==========

    // 2. constructor

    /**
     * 2.1 no args constructor
     */
    public Person() {
    }

    /**
     * 2.2 full args constructor
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // end constructor
    // ==========

    // 3. getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // end getters and setters
    // ==========

    // 4. toString

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
