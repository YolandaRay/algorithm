package org.design.creational.builder;

/*

 */
public class Person {
    int id;
    String name;
    int age;
    boolean gender;
    double weight;
    double height;
    int score;
    Location location;

    private Person() {
    }

    public static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder weight(double weight) {
            person.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            person.score = score;
            return this;
        }

        public PersonBuilder location(Location location) {
            person.location = location;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", score=" + score +
                ", location=" + location +
                '}';
    }
}

class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
