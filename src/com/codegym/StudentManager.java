package com.codegym;

import java.util.LinkedList;

public class StudentManager {
    private LinkedList<Student> students = new LinkedList<>();

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortStudents() {
        students.sort(Student::compareTo);
    }

    public void updateStudent(String id, Student student) {
        int index = findStudentById(id);
        students.set(index, student);
    }

    public void deleteStudent(String id) {
        int index = findStudentById(id);
        students.remove(index);
    }

    public int findStudentByScoreMax() {
        int index = -1;
        double max = students.get(0).getScores();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getScores() > max) {
                max = students.get(i).getScores();
                index = i;
            }
        }
        return index;
    }

    public int searchStudentByIdBinary(String id) {
        int low = 0;
        int high = students.size() - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (id.compareTo(students.get(mid).getId()) == 0) {
                return mid;
            } else if (id.compareTo(students.get(mid).getId()) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int findStudentById(String id) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (id.equals(students.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void showStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
