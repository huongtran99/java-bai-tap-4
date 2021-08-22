package com.codegym;

public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private String classed;
    private String country;
    private double scores;

    public Student() {

    }

    public Student(String id, String name, String country, String classed, double scores) {
        this.id = id;
        this.name = name;
        this.classed = classed;
        this.country = country;
        this.scores = scores;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClassed() {
        return classed;
    }

    public void setClassed(String classed) {
        this.classed = classed;
    }

    public double getScores() {
        return scores;
    }

    public void setScores(double scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", classed='" + classed + '\'' +
                ", country='" + country + '\'' +
                ", scores=" + scores +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
