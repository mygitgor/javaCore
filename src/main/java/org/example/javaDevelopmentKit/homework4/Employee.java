package org.example.javaDevelopmentKit.homework4;

public class Employee {
    //* Создать класс справочник сотрудников, который содержит внутри
    //* коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
    //* Табельный номер
    //* Номер телефона
    //* Имя
    //* Стаж
    private static int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    public Employee(String phoneNumber, String name, int experience) {

        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
        employeeId++;
    }


//----------------------------------------------------region geter and seter
    public static int getEmployeeId() {
        return employeeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
