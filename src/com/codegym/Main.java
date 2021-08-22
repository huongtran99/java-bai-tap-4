package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            menu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            studentManager.sortStudents();
            switch (choice) {
                case 1: {
                    addStudent(scanner, studentManager);
                    break;
                }
                case 2: {
                    showStudent(studentManager);
                    break;
                }
                case 3: {
                    updateStudent(scanner, studentManager);
                    break;
                }
                case 4: {
                    deleteStudent(scanner, studentManager);
                    break;
                }
                case 5: {
                    searchStudent(studentManager);
                    break;
                }
                case 6: {
                    sortStudent(scanner, studentManager);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void sortStudent(Scanner scanner, StudentManager studentManager) {
        System.out.print("Nhập id cần tìm kiếm: ");
        String id = scanner.nextLine();
        int mid = studentManager.searchStudentByIdBinary(id);
        if(mid != -1) {
            System.out.println(studentManager.getStudents().get(mid).toString());
        } else {
            System.out.println("Không tìm thấy mô");
        }
    }

    private static void showStudent(StudentManager studentManager) {
        System.out.println("Danh sách sinh viên");
        studentManager.showStudent();
    }

    private static void addStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("Thêm sinh viên");
        Student student = inputStudent(scanner);
        studentManager.addStudent(student);
    }

    private static void updateStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("Cập nhật danh sách sinh viên");
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();
        int index = studentManager.findStudentById(id);
        if (index != -1) {
            Student student = inputStudent(scanner);
            studentManager.updateStudent(id, student);
        } else {
            System.out.println("Không tìm thấy mã sinh viên nào cả");
        }
    }

    private static void deleteStudent(Scanner scanner, StudentManager studentManager) {
        System.out.println("Xóa 1 sinh viên");
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();
        int index = studentManager.findStudentById(id);
        if (index != -1) {
            studentManager.deleteStudent(id);
        } else {
            System.out.println("Không tìm thấy mã sinh viên nào cả");
        }
    }

    private static void searchStudent(StudentManager studentManager) {
        System.out.println("Sinh viên có điểm cao nhất là");
        int index = studentManager.findStudentByScoreMax();
        if (index != -1) {
            System.out.println(studentManager.getStudents().get(index).toString());
        } else {
            System.out.println("Chưa có sinh viên nào cả :((");
        }
    }

    private static Student inputStudent(Scanner scanner) {
        System.out.println("Nhập thông tin sinh viên");
        System.out.print("Nhập mã sinh viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập lớp học: ");
        String classed = scanner.nextLine();
        System.out.print("Nhập quê quán: ");
        String country = scanner.nextLine();
        System.out.print("Nhập điểm: ");
        double scores = scanner.nextDouble();
        return new Student(id, name, classed, country, scores);
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Sửa thông tin sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm kiếm sinh viên có điểm cao nhất");
        System.out.println("6. Tìm kiếm thông tin theo mã sinh viên");
        System.out.println("0. Thoát");
    }
}
